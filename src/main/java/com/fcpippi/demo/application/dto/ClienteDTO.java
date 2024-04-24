package com.fcpippi.demo.application.dto;

import com.fcpippi.demo.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long codigo;
    private String nome;
    private String email;

    public static ClienteDTO fromModel(Cliente cliente) {
        return new ClienteDTO(
            cliente.getCodigo(),
            cliente.getNome(),
            cliente.getEmail()
        );
    }
}