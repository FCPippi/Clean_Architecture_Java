package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.repository.PagamentoRepository;
import com.fcpippi.demo.infraestructure.entity.Assinatura;
import com.fcpippi.demo.infraestructure.entity.Pagamento;
import com.fcpippi.demo.infraestructure.persistence.jpa.AssinaturaJpaRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.PagamentoJpaRepository;

import java.time.LocalDate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PagamentoRepositoryImpl implements PagamentoRepository {
    private final PagamentoJpaRepository pagamentoJpaRepository;
    private final AssinaturaJpaRepository assinaturaJpaRepository;

    public PagamentoRepositoryImpl(PagamentoJpaRepository pagamentoJpaRepository, AssinaturaJpaRepository assinaturaJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
        this.assinaturaJpaRepository = assinaturaJpaRepository;
    }

    @Override
    public Object registrar(Pagamento pagamento, String promocao) {
        Assinatura assinatura = pagamento.getAssinatura();
        LocalDate dataValidade = assinatura.getFimVigencia();
        Double valorEstornado = 0.00;
        String status;

        if (pagamento.getValorPago().equals(assinatura.getAplicativo().getCustoMensal())) {
            if (dataValidade.isAfter(LocalDate.now())) {
                dataValidade = dataValidade.plusDays(30);
            } else {
                dataValidade = LocalDate.now().plusDays(30);
            }
            status = "PAGAMENTO_OK";
        } else {
            valorEstornado = pagamento.getValorPago();
            status = "VALOR_INCORRETO";
        }

        if(promocao != null) {
            if(promocao.equals("PROMO")) {
                valorEstornado = pagamento.getValorPago() * 0.2;
            }
    
        }
       
        assinatura.setFimVigencia(dataValidade);
        assinaturaJpaRepository.save(assinatura);

        pagamento.setAssinatura(assinatura);
        pagamentoJpaRepository.save(pagamento);
        String[] obj = {status, dataValidade.toString(), valorEstornado.toString()};
        return obj;
    }
}