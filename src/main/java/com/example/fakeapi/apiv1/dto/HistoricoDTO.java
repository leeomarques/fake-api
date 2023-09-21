package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("pastoreioMudancaDeNivel")
    private String pastoreioMudancaDeNivel;

    @JsonProperty("ano")
    private Integer ano;

    @JsonProperty("obs")
    private String obs;

    @JsonProperty("ministerios")
    private List<String> ministerios;
}
