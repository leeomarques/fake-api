package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.AcompanhadoresComunitarioDTO;
import com.example.fakeapi.infrastrucutre.entities.AcompanhadoresComunitarioEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AcompanhamentoComunitarioConverter {

    public AcompanhadoresComunitarioEntity toEntity(AcompanhadoresComunitarioDTO dto) {
        return AcompanhadoresComunitarioEntity.builder()
                                              .id(dto.getId())
                                              .missionario(MissionarioEntity.builder().build())
                                              .build();
    }

    public AcompanhadoresComunitarioEntity toEntityUpdate(AcompanhadoresComunitarioEntity entity, AcompanhadoresComunitarioDTO dto, Long id) {
        return AcompanhadoresComunitarioEntity.builder()
                                              .id(id)
                                              .missionario(dto.getMissionario() != null ? dto.getMissionario() : entity.getMissionario())
                                              .build();

    }

    public AcompanhadoresComunitarioDTO toDTO(AcompanhadoresComunitarioEntity entity) {
        return AcompanhadoresComunitarioDTO.builder()
                                           .id(entity.getId())
                                           .missionario(MissionarioEntity.builder().build())
                                           .build();
    }

    public List<AcompanhadoresComunitarioDTO> toListDTO(List<AcompanhadoresComunitarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
