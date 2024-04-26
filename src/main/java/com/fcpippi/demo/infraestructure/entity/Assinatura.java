package com.fcpippi.demo.infraestructure.entity;

import com.fcpippi.demo.domain.model.AssinaturaModel;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne
    private Aplicativo aplicativo;

    @ManyToOne
    private Cliente cliente;

    private LocalDate inicioVigencia;

    private LocalDate fimVigencia;

    public static AssinaturaModel toModel(Assinatura assinatura) {
        return new AssinaturaModel(
                assinatura.getCodigo(),
                Aplicativo.toModel(assinatura.getAplicativo()),
                Cliente.toModel(assinatura.getCliente()),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                assinatura.getFimVigencia().isBefore(LocalDate.now()) ? "CANCELADA" : "ATIVA");
    }

    public static Assinatura fromModel(AssinaturaModel assinaturaModel) {
        return new Assinatura(
                assinaturaModel.getCodigo(),
                Aplicativo.fromModel(assinaturaModel.getAplicativo()),
                Cliente.fromModel(assinaturaModel.getCliente()),
                assinaturaModel.getInicioVigencia(),
                assinaturaModel.getFimVigencia());
    }
}