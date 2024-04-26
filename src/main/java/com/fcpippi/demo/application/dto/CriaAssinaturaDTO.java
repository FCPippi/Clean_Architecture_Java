package com.fcpippi.demo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriaAssinaturaDTO {
    private Long codigoCliente;
    private Long codigoAplicativo;
}