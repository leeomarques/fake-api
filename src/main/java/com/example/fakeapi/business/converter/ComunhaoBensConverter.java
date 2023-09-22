package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ComunhaoBensDTO;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoBensEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComunhaoBensConverter {

    public ComunhaoBensEntity toEntity(ComunhaoBensDTO dto) {
        return ComunhaoBensEntity
                .builder()
                .id(dto.getId())
                .missionario(MissionarioEntity.builder().build())
                .valor10Percent(dto.getValor10Percent())
                .valor5Percent(dto.getValor5Percent())
                .mesReferencia(dto.getMesReferencia())
                .anoReferencia(dto.getAnoReferencia())
                .situacao(dto.getSituacao())
                .build();
    }

    public ComunhaoBensEntity toEntityUpdate(ComunhaoBensEntity entity, ComunhaoBensDTO dto, Long id) {
        return ComunhaoBensEntity
                .builder()
                .id(id)
                .missionario(MissionarioEntity.builder().build())
                .valor10Percent(dto.getValor10Percent() != null ? dto.getValor10Percent() : entity.getValor10Percent())
                .valor5Percent(dto.getValor5Percent() != null ? dto.getValor5Percent() : entity.getValor5Percent())
                .mesReferencia(dto.getMesReferencia() != null ? dto.getMesReferencia() : entity.getMesReferencia())
                .anoReferencia(dto.getAnoReferencia() != null ? dto.getAnoReferencia() : entity.getAnoReferencia())
                .situacao(dto.getSituacao() != null ? dto.getSituacao() : entity.getSituacao())
                .build();
    }

    public ComunhaoBensDTO toDTO(ComunhaoBensEntity entity) {
        return ComunhaoBensDTO
                .builder()
                .id(entity.getId())
                .missionarioId(entity.getMissionario().getNomeCompleto())
                .valor10Percent(entity.getValor10Percent())
                .valor5Percent(entity.getValor5Percent())
                .mesReferencia(entity.getMesReferencia())
                .anoReferencia(entity.getAnoReferencia())
                .situacao(entity.getSituacao())
                .build();
    }

    public List<ComunhaoBensDTO> toListDTO(List<ComunhaoBensEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
