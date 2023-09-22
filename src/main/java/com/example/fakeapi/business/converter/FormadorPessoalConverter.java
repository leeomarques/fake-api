package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.FormadorPessoalDTO;
import com.example.fakeapi.infrastrucutre.entities.FormadorPessoalEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormadorPessoalConverter {

    public FormadorPessoalEntity toEntity(FormadorPessoalDTO dto) {
        return FormadorPessoalEntity.builder().id(dto.getId()).missionario(MissionarioEntity.builder().build()).build();
    }

    public FormadorPessoalEntity toEntityUpdate(FormadorPessoalEntity entity, FormadorPessoalDTO dto, Long id) {
        return FormadorPessoalEntity
                .builder()
                .id(id)
                .missionario(dto.getMissionario() != null ? dto.getMissionario() : entity.getMissionario())
                .build();

    }

    public FormadorPessoalDTO toDTO(FormadorPessoalEntity entity) {
        return FormadorPessoalDTO.builder().id(entity.getId()).missionario(MissionarioEntity.builder().build()).build();
    }

    public List<FormadorPessoalDTO> toListDTO(List<FormadorPessoalEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
