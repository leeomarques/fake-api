package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.FormadorPessoalDTO;
import com.example.fakeapi.infrastrucutre.entities.FormadorPessoalEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormadorPessoalConverter {

    public FormadorPessoalEntity toEntity(FormadorPessoalDTO dto) {
        return FormadorPessoalEntity
                .builder()
                .id(dto.getId()) // Se estiver criando um novo, pode usar UUID.randomUUID() para gerar um ID
                .nome(dto.getNome())
                .build();
    }

    public FormadorPessoalDTO toDTO(FormadorPessoalEntity entity) {
        return FormadorPessoalDTO
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    public List<FormadorPessoalDTO> toListDTO(List<FormadorPessoalEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
