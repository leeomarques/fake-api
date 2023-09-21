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
    private String id;

    @JsonProperty("missionarioId")
    private String missionarioId;

    @JsonProperty("valor10Percent")
    private BigDecimal valor10Percent;

    @JsonProperty("valor5Percent")
    private BigDecimal valor5Percent;

    @JsonProperty("situacao")
    private String situacao;

}
