package com.example.fakeapi.apiv1.dto;

import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcompanhadoresComunitarioDTO {

    @JsonProperty("id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;

}
