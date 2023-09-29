package com.example.fakeapi.apiv1.dto;

import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissaoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomeMissao")
    private String nomeMissao;

    @JsonProperty("responsavelLocal")
    private MissionarioEntity responsavelLocal;

    @JsonProperty("coordenadorApostolico")
    private MissionarioEntity coordenadorApostolico;

}
