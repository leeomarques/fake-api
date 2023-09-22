package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReciclagemConverter {

    public ReciclagemEntity toEntity(ReciclagemDTO dto) {
        return ReciclagemEntity.builder().id(dto.getId()).dataPrevista(dto.getDataPrevista()).dataConclusao(dto.getDataConclusao()).build();
    }

    public ReciclagemEntity toEntityUpdate(ReciclagemEntity entity, ReciclagemDTO dto, Long id) {
        return ReciclagemEntity.builder().id(id) // Use o ID fornecido
                               .dataPrevista(dto.getDataPrevista()).dataConclusao(dto.getDataConclusao()).build();
    }


    public ReciclagemDTO toDTO(ReciclagemEntity entity) {
        return ReciclagemDTO
                .builder()
                .id(Long.valueOf(String.valueOf(entity.getId())))
                .dataPrevista(entity.getDataPrevista())
                .dataConclusao(entity.getDataConclusao())
                .build();
    }

    public List<ReciclagemDTO> toListDTO(List<ReciclagemEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
