package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissaoDTO;
import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissaoConverter {

    public MissaoEntity toEntity(MissaoDTO dto) {
        return MissaoEntity
                .builder()
                .nomeDaMissao(dto.getNomeDaMissao())
                .nivelDaMissao(dto.getNivelDaMissao())
                .tipoDaMissao(dto.getTipoDaMissao())
                .build();
    }

    public MissaoDTO toDTO(MissaoEntity entity) {
        return MissaoDTO
                .builder()
                .nomeDaMissao(entity.getNomeDaMissao())
                .nivelDaMissao(entity.getNivelDaMissao())
                .tipoDaMissao(entity.getTipoDaMissao())
                .build();
    }

    public List<MissaoDTO> toListDTO(List<MissaoEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
