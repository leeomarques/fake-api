package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.AcompanhamentoComunitarioDTO;
import com.example.fakeapi.infrastrucutre.entities.AcompanhamentoComunitarioEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AcompanhamentoComunitarioConverter {

    public AcompanhamentoComunitarioEntity toEntity(AcompanhamentoComunitarioDTO dto) {
        return AcompanhamentoComunitarioEntity.builder()
                                              .id(dto.getId())
                                              .missionario(MissionarioEntity.builder().build())
                                              .build();
    }

    public AcompanhamentoComunitarioEntity toEntityUpdate(AcompanhamentoComunitarioEntity entity, AcompanhamentoComunitarioDTO dto, Long id) {
        return AcompanhamentoComunitarioEntity.builder()
                                              .id(id)
                                              .missionario(dto.getMissionario() != null ? dto.getMissionario() : entity.getMissionario())
                                              .build();

    }

    public AcompanhamentoComunitarioDTO toDTO(AcompanhamentoComunitarioEntity entity) {
        return AcompanhamentoComunitarioDTO.builder()
                                           .id(entity.getId())
                                           .missionario(MissionarioEntity.builder().build())
                                           .build();
    }

    public List<AcompanhamentoComunitarioDTO> toListDTO(List<AcompanhamentoComunitarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
