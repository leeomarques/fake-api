package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ComunhaoBensDTO;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoBensEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComunhaoBensConverter {

    public ComunhaoBensEntity toEntity(ComunhaoBensDTO dto) {
        return ComunhaoBensEntity
                .builder()
                .missionario(null) // Preencha o missionario se necessário
                .valor10Percent(dto.getValor10Percent())
                .valor5Percent(dto.getValor5Percent())
                .situacao(dto.getSituacao())
                .build();
    }

    public ComunhaoBensDTO toDTO(ComunhaoBensEntity entity) {
        return ComunhaoBensDTO
                .builder()
                .id(String.valueOf(entity.getId()))
                .missionarioId(entity.getMissionario() != null ? entity.getMissionario().getId() : null)
                .valor10Percent(entity.getValor10Percent())
                .valor5Percent(entity.getValor5Percent())
                .situacao(entity.getSituacao())
                .build();
    }

    public List<ComunhaoBensDTO> toListDTO(List<ComunhaoBensEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
