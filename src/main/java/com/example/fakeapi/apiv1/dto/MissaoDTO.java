package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissaoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomeDaMissao")
    private String nomeDaMissao;

    @JsonProperty("nivelDaMissao")
    private String nivelDaMissao;

    @JsonProperty("tipoDaMissao")
    private String tipoDaMissao;

    @JsonProperty("responsavelLocalId")
    private String responsavelLocalId;

    @JsonProperty("coordenadorApostolicoId")
    private String coordenadorApostolicoId;
}
