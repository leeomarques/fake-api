package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ReciclagemConverter {

    public ReciclagemEntity toEntity(ReciclagemDTO dto) {
        return ReciclagemEntity.builder().id(Long.parseLong(String.valueOf(UUID.randomUUID()))) // Gere um novo ID
                               .dataPrevista(dto.getDataPrevista()).dataConclusao(dto.getDataConclusao()).build();
    }

    public ReciclagemEntity toEntityUpdate(ReciclagemEntity entity, ReciclagemDTO dto) {
        return ReciclagemEntity.builder().id(entity.getId()) // Mantenha o ID existente
                               .dataPrevista(dto.getDataPrevista()).dataConclusao(dto.getDataConclusao()).build();
    }

    public ReciclagemDTO toDTO(ReciclagemEntity entity) {
        return ReciclagemDTO
                .builder()
                .id(String.valueOf(entity.getId()))
                .dataPrevista(entity.getDataPrevista())
                .dataConclusao(entity.getDataConclusao())
                .build();
    }

    public List<ReciclagemDTO> toListDTO(List<ReciclagemEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
