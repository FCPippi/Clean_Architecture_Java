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

    public PagamentoRepositoryImpl(PagamentoJpaRepository pagamentoJpaRepository,
            AssinaturaJpaRepository assinaturaJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
        this.assinaturaJpaRepository = assinaturaJpaRepository;
    }

    @Override
    public Object registrar(String dia, String mes, String ano, long codigoAssinatura, double valorPago) {
        Assinatura assinatura = assinaturaJpaRepository.findById(codigoAssinatura).orElse(null);
        if (assinatura == null)
            return null;

        LocalDate dataValidade = assinatura.getFimVigencia();
        Double valorAplicativo = assinatura.getAplicativo().getCustoMensal();
        Double valorEstornado = valorPago;
        String status = "VALOR_INCORRETO";

        if (valorPago >= assinatura.getAplicativo().getCustoMensal()) {

            if (dataValidade.isAfter(LocalDate.now())) {
                dataValidade = dataValidade.plusDays(30);
                valorEstornado = valorPago - valorAplicativo;
                status = "PAGAMENTO_OK";
            } else {
                dataValidade = LocalDate.now().plusDays(30);
                valorEstornado = valorPago - valorAplicativo;
                status = "PAGAMENTO_OK";
            }
            Pagamento pagamento = new Pagamento();
            LocalDate dataPagamento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

            pagamento.setValorPago(valorPago);
            pagamento.setDataPagamento(dataPagamento);
            pagamento.setAssinatura(assinatura);

            pagamentoJpaRepository.save(pagamento);
        }
        assinatura.setFimVigencia(dataValidade);
        assinaturaJpaRepository.save(assinatura);

        String[] obj = { status, dataValidade.toString(), valorEstornado.toString() };

        return obj;
    }
}