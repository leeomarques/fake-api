package com.example.fakeapi.apiv1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunhaoDeBensDTO {

    private Long id;

    private Double dezPorcentos;

    private Double cincoPorcentos;

    private String observacoes;

    private Long missionario;

}
