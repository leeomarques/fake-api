package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReciclagemDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dataPrevista")
    private LocalDate dataPrevista;

    @JsonProperty("dataConclusao")
    private LocalDate dataConclusao;

    @JsonProperty("missionarioId")
    private String missionario;
}
