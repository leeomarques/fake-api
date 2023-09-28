package com.example.fakeapi.apiv1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoDTO {

    private Long id;

    private String pastoreio;

    private String ano;

    private String observacoes;

    private Long missionario;

}
