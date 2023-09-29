package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunhaoDeBensDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dezPorcentos")
    private Double dezPorcentos;

    @JsonProperty("cincoPorcentos")
    private Double cincoPorcentos;

    @JsonProperty("observacoes")
    private String observacoes;

    @JsonProperty("missionario")
    private MissionarioDTO missionario;

}
