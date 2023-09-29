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
public class MinisterioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("ministerio")
    private String ministerio;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("prioridade")
    private String prioridade;

    @JsonProperty("missionario")
    private MissionarioDTO missionario;

}
