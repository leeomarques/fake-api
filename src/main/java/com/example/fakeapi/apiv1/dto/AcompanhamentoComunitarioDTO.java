package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcompanhamentoComunitarioDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

}
