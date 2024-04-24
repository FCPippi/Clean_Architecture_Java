package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.model.AssinaturaModel;
import com.fcpippi.demo.domain.repository.AssinaturaRepository;
import com.fcpippi.demo.infraestructure.entity.Aplicativo;
import com.fcpippi.demo.infraestructure.entity.Assinatura;
import com.fcpippi.demo.infraestructure.entity.Cliente;
import com.fcpippi.demo.infraestructure.persistence.jpa.AplicativoJpaRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.AssinaturaJpaRepository;
import com.fcpippi.demo.infraestructure.persistence.jpa.ClienteJpaRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
@Primary
public class AssinaturaRepositoryImpl implements AssinaturaRepository {
    private final AssinaturaJpaRepository assinaturaJpaRepository;
    private final AplicativoJpaRepository aplicativoJpaRepository;
    private final ClienteJpaRepository clienteJpaRepository;

    public AssinaturaRepositoryImpl(AssinaturaJpaRepository assinaturaJpaRepository,
            AplicativoJpaRepository aplicativoJpaRepository,
            ClienteJpaRepository clienteJpaRepository) {
        this.assinaturaJpaRepository = assinaturaJpaRepository;
        this.aplicativoJpaRepository = aplicativoJpaRepository;
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public AssinaturaModel criar(Long codigoCliente, Long codigoAplicativo) {
        Cliente cliente = clienteJpaRepository.findById(codigoCliente).orElse(null);
        Aplicativo aplicativo = aplicativoJpaRepository.findById(codigoAplicativo).orElse(null);
        if (cliente != null && aplicativo != null) {
            Assinatura assinatura = new Assinatura();
            assinatura.setCliente(cliente);
            assinatura.setAplicativo(aplicativo);
            assinatura.setInicioVigencia(LocalDate.now());
            assinatura.setFimVigencia(LocalDate.now().plusDays(7));
            assinaturaJpaRepository.save(assinatura);
            return Assinatura.toModel(assinatura);
        }
        return null;
    }

    @Override
    public List<AssinaturaModel> buscarPorTipo(String tipo) {
        if (tipo.equalsIgnoreCase("ATIVAS")) {
            return assinaturaJpaRepository.findAll().stream()
                    .filter(assinatura -> assinatura.getFimVigencia().isAfter(LocalDate.now()))
                    .map(assinatura -> Assinatura.toModel(assinatura))
                    .toList();
        } else if (tipo.equalsIgnoreCase("CANCELADAS")) {
            return assinaturaJpaRepository.findAll().stream()
                    .filter(assinatura -> assinatura.getFimVigencia().isBefore(LocalDate.now()))
                    .map(assinatura -> Assinatura.toModel(assinatura))
                    .toList();
        } else {
            return assinaturaJpaRepository.findAll().stream().map(assinatura -> Assinatura.toModel(assinatura))
                    .toList();
        }
    }

    @Override
    public List<AssinaturaModel> buscarPorCliente(Long codigoCliente) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> assinatura.getCliente().getCodigo() == codigoCliente)
                .map(assinatura -> Assinatura.toModel(assinatura))
                .toList();
    }

    @Override
    public List<AssinaturaModel> buscarPorAplicativo(Long codigoAplicativo) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> assinatura.getAplicativo().getCodigo() == codigoAplicativo)
                .map(assinatura -> Assinatura.toModel(assinatura))
                .toList();
    }

    @Override
    public boolean assinaturaValida(Long codigoAssinatura) {
        Assinatura assinatura = assinaturaJpaRepository.findById(codigoAssinatura).orElse(null);
        if (assinatura != null) {
            return assinatura.getFimVigencia().isAfter(LocalDate.now());
        }
        return false;
    }

    @Override
    public AssinaturaModel buscaPorClienteAplicativo(Long codigoCliente, Long codigoAplicativo) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> (assinatura.getAplicativo().getCodigo() == codigoAplicativo
                        && assinatura.getCliente().getCodigo() == codigoCliente))
                .map(assinatura -> Assinatura.toModel(assinatura)).findFirst().orElse(null);
    }
}