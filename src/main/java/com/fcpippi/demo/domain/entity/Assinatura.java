package com.fcpippi.demo.domain.entity;

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
    private Long codigo;
    
    @ManyToOne
    private Aplicativo aplicativo;
    
    @ManyToOne
    private Cliente cliente;
    
    private LocalDate inicioVigencia;
    
    private LocalDate fimVigencia;
}