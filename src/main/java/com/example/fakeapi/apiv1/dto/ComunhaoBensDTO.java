package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComunhaoBensDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("missionarioId")
    private String missionarioId;

    @JsonProperty("valor10Percent")
    private BigDecimal valor10Percent;

    @JsonProperty("valor5Percent")
    private BigDecimal valor5Percent;

    @JsonProperty("mes_referencia")
    private String mesReferencia;

    @JsonProperty("ano_referencia")
    private String anoReferencia;

    @JsonProperty("situacao")
    private String situacao;

}
