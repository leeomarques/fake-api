package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.FormadorComunitarioDTO;
import com.example.fakeapi.infrastrucutre.entities.FormadorComunitarioEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormadorComunitarioConverter {

    public FormadorComunitarioEntity toEntity(FormadorComunitarioDTO dto) {
        return FormadorComunitarioEntity.builder().id(dto.getId()).missionario(MissionarioEntity.builder().build()).build();
    }

    public FormadorComunitarioEntity toEntityUpdate(FormadorComunitarioEntity entity, FormadorComunitarioDTO dto, Long id) {
        return FormadorComunitarioEntity
                .builder()
                .id(id)
                .missionario(dto.getMissionario() != null ? dto.getMissionario() : entity.getMissionario())
                .build();

    }

    public FormadorComunitarioDTO toDTO(FormadorComunitarioEntity entity) {
        return FormadorComunitarioDTO.builder().id(entity.getId()).missionario(MissionarioEntity.builder().build()).build();
    }

    public List<FormadorComunitarioDTO> toListDTO(List<FormadorComunitarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
