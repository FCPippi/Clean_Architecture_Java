package com.fcpippi.demo.infraestructure.entity;

import com.fcpippi.demo.domain.model.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String nome;
    
    private String email;

    public static ClienteModel toModel(Cliente cliente) {
        return new ClienteModel(
            cliente.getCodigo(),
            cliente.getNome(),
            cliente.getEmail()
        );
    }
}