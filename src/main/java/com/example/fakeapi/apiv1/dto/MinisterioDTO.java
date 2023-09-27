package com.example.fakeapi.apiv1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinisterioDTO {

    private Long id;

    private String ministerio;

    private String tipo;

    private String prioridade;

    private Long missionario;

}
