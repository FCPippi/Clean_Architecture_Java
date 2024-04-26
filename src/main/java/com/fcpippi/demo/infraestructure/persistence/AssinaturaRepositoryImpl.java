package com.fcpippi.demo.infraestructure.persistence;

import com.fcpippi.demo.domain.model.AplicativoModel;
import com.fcpippi.demo.domain.model.AssinaturaModel;
import com.fcpippi.demo.domain.model.ClienteModel;
import com.fcpippi.demo.domain.repository.AssinaturaRepository;
import com.fcpippi.demo.infraestructure.entity.Aplicativo;
import com.fcpippi.demo.infraestructure.entity.Assinatura;
import com.fcpippi.demo.infraestructure.entity.Cliente;
import com.fcpippi.demo.infraestructure.persistence.jpa.AssinaturaJpaRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
public class AssinaturaRepositoryImpl implements AssinaturaRepository {
    private final AssinaturaJpaRepository assinaturaJpaRepository;
    private final AplicativoRepositoryImpl aplicativoJpaRepository;
    private final ClienteRepositoryImpl clienteJpaRepository;

    public AssinaturaRepositoryImpl(AssinaturaJpaRepository assinaturaJpaRepository,
            AplicativoRepositoryImpl aplicativoRepository,
            ClienteRepositoryImpl clienteRepository) {
        this.assinaturaJpaRepository = assinaturaJpaRepository;
        this.aplicativoJpaRepository = aplicativoRepository;
        this.clienteJpaRepository = clienteRepository;
    }

    @Override
    public AssinaturaModel buscaPorId(long codigoAssinatura) {
        return Assinatura.toModel(assinaturaJpaRepository.findById(codigoAssinatura).get());
    }

    @Override
    public AssinaturaModel criar(long codigoCliente, long codigoAplicativo) {
        ClienteModel cliente = clienteJpaRepository.buscaPorId(codigoCliente);
        AplicativoModel aplicativo = aplicativoJpaRepository.buscarPorId(codigoAplicativo);
        AssinaturaModel assinaturaExistente = this.buscaPorClienteAplicativo(cliente.getCodigo(),
                aplicativo.getCodigo());
        if (cliente != null && aplicativo != null && assinaturaExistente == null) {
            Assinatura assinatura = new Assinatura();
            assinatura.setCliente(Cliente.fromModel(cliente));
            assinatura.setAplicativo(Aplicativo.fromModel(aplicativo));
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
    public List<AssinaturaModel> buscarPorCliente(long codigoCliente) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> assinatura.getCliente().getCodigo() == codigoCliente)
                .map(assinatura -> Assinatura.toModel(assinatura))
                .toList();
    }

    @Override
    public List<AssinaturaModel> buscarPorAplicativo(long codigoAplicativo) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> assinatura.getAplicativo().getCodigo() == codigoAplicativo)
                .map(assinatura -> Assinatura.toModel(assinatura))
                .toList();
    }

    @Override
    public boolean assinaturaValida(long codigoAssinatura) {
        Assinatura assinatura = assinaturaJpaRepository.findById(codigoAssinatura).orElse(null);
        if (assinatura != null) {
            return assinatura.getFimVigencia().isAfter(LocalDate.now())
                    || assinatura.getFimVigencia().isEqual(LocalDate.now());
        }
        return false;
    }

    @Override
    public AssinaturaModel buscaPorClienteAplicativo(long codigoCliente, long codigoAplicativo) {
        return assinaturaJpaRepository.findAll().stream()
                .filter(assinatura -> (assinatura.getAplicativo().getCodigo() == codigoAplicativo
                        && assinatura.getCliente().getCodigo() == codigoCliente))
                .map(assinatura -> Assinatura.toModel(assinatura)).findFirst().orElse(null);
    }
}