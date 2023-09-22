package com.example.fakeapi.apiv1.dto;

import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MinisterioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("prioridade")
    private String prioridade;

    @ManyToMany(mappedBy = "missionarios")
    private List<MissionarioDTO> missionarios;
}
