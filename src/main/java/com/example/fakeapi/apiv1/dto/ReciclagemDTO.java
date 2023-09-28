package com.example.fakeapi.apiv1.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReciclagemDTO {

    private Long id;

    private LocalDateTime dataPrevista;

    private LocalDateTime dataConclusao;

    private String local;

    private Long missionario;

}
