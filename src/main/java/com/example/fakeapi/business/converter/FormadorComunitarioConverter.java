package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.FormadorComunitarioDTO;
import com.example.fakeapi.infrastrucutre.entities.FormadorComunitarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormadorComunitarioConverter {

    public FormadorComunitarioEntity toEntity(FormadorComunitarioDTO dto) {
        return FormadorComunitarioEntity
                .builder()
                .id(dto.getId()) // Se estiver criando um novo, pode usar UUID.randomUUID() para gerar um ID
                .nome(dto.getNome())
                .build();
    }

    public FormadorComunitarioDTO toDTO(FormadorComunitarioEntity entity) {
        return FormadorComunitarioDTO
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    public List<FormadorComunitarioDTO> toListDTO(List<FormadorComunitarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
