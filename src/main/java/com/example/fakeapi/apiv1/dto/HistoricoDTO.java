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
public class HistoricoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("pastoreio")
    private String pastoreio;

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("observacoes")
    private String observacoes;

    @JsonProperty("missionario")
    private MissionarioDTO missionario;

}
