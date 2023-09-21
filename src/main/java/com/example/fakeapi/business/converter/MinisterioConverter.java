package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MinisterioDTO;
import com.example.fakeapi.infrastrucutre.entities.MinisterioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MinisterioConverter {

    public MinisterioEntity toEntity(MinisterioDTO dto) {
        return MinisterioEntity
                .builder()
                .id(dto.getId()) // Se estiver criando um novo, pode usar UUID.randomUUID() para gerar um ID
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .prioridade(dto.getPrioridade())
                .build();
    }

    public MinisterioDTO toDTO(MinisterioEntity entity) {
        return MinisterioDTO
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .tipo(entity.getTipo())
                .prioridade(entity.getPrioridade())
                .build();
    }

    public List<MinisterioDTO> toListDTO(List<MinisterioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
