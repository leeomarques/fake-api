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
                .id(dto.getId())
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .prioridade(dto.getPrioridade())
                .missionarios(null)
                .build();
    }

    public MinisterioEntity toEntityUpdate(MinisterioEntity entity, MinisterioDTO dto, Long id) {
        return MinisterioEntity
                .builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .tipo(dto.getTipo() != null ? dto.getTipo() : entity.getTipo())
                .prioridade(dto.getPrioridade() != null ? dto.getPrioridade() : entity.getPrioridade())
                .missionarios(null)
                .build();
    }

    public MinisterioDTO toDTO(MinisterioEntity entity) {
        return MinisterioDTO
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .tipo(entity.getTipo())
                .prioridade(entity.getPrioridade())
                .missionarios(null)
                .build();
    }

    public List<MinisterioDTO> toListDTO(List<MinisterioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
