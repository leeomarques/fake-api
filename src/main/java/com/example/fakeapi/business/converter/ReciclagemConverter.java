package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReciclagemConverter {

    public ReciclagemEntity toEntity(ReciclagemDTO dto) {
        MissionarioEntity missionarioEntity = new MissionarioEntity();
        return ReciclagemEntity
                .builder()
                .id(dto.getId())
                .missionario(MissionarioEntity.builder().id(missionarioEntity.getId()).build())
                .dataPrevista(dto.getDataPrevista())
                .dataConclusao(dto.getDataConclusao())
                .build();
    }

    public ReciclagemEntity toEntityUpdate(ReciclagemEntity entity, ReciclagemDTO dto, Long id) {
        return ReciclagemEntity
                .builder()
                .id(id)
                .missionario(entity.getMissionario() != null ? MissionarioEntity.builder().build() : entity.getMissionario())
                .dataPrevista(dto.getDataPrevista() != null ? dto.getDataPrevista() : entity.getDataPrevista())
                .dataConclusao(dto.getDataConclusao() != null ? dto.getDataConclusao() : entity.getDataConclusao())
                .build();
    }


    public ReciclagemDTO toDTO(ReciclagemEntity entity) {
        return ReciclagemDTO
                .builder()
                .id(entity.getId())
                .missionario(entity.getMissionario())
                .dataPrevista(entity.getDataPrevista())
                .dataConclusao(entity.getDataConclusao())
                .build();
    }

    public List<ReciclagemDTO> toListDTO(List<ReciclagemEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
