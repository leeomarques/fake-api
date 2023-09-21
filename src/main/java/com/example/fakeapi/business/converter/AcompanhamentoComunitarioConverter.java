package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.AcompanhamentoComunitarioDTO;
import com.example.fakeapi.infrastrucutre.entities.AcompanhamentoComunitarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AcompanhamentoComunitarioConverter {

    public AcompanhamentoComunitarioEntity toEntity(AcompanhamentoComunitarioDTO dto) {
        return AcompanhamentoComunitarioEntity.builder()
                                              .id(String.valueOf(UUID.randomUUID()))
                                              .nome(dto.getNome())
                                              .build();
    }

    public AcompanhamentoComunitarioEntity toEntityUpdate(AcompanhamentoComunitarioEntity entity, AcompanhamentoComunitarioDTO dto, String id) {
        return AcompanhamentoComunitarioEntity.builder()
                                              .id(id)
                                              .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                                              .build();

    }

    public AcompanhamentoComunitarioDTO toDTO(AcompanhamentoComunitarioEntity entity) {
        return AcompanhamentoComunitarioDTO.builder()
                                           .id(entity.getId())
                                           .nome(entity.getNome())
                                           .build();
    }

    public List<AcompanhamentoComunitarioDTO> toListDTO(List<AcompanhamentoComunitarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
