package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReciclagemDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dataPrevista")
    private LocalDateTime dataPrevista;

    @JsonProperty("dataConclusao")
    private LocalDateTime dataConclusao;

    @JsonProperty("local")
    private String local;

    @JsonProperty("missionario")
    private MissionarioDTO missionario;

}
