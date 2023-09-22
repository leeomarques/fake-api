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
                .id(dto.getId())
                .nomeDaMissao(dto.getNomeDaMissao())
                .nivelDaMissao(dto.getNivelDaMissao())
                .tipoDaMissao(dto.getTipoDaMissao())
                .responsavelLocal(null)
                .coordenadorApostolico(null)
                .build();
    }

    public MissaoEntity toEntityUpdate(MissaoEntity entity, MissaoDTO dto, Long id) {
        return MissaoEntity
                .builder()
                .id(id)
                .nomeDaMissao(dto.getNomeDaMissao() != null ? dto.getNomeDaMissao() : entity.getNomeDaMissao())
                .nivelDaMissao(dto.getNivelDaMissao() != null ? dto.getNivelDaMissao() : entity.getNivelDaMissao())
                .tipoDaMissao(dto.getTipoDaMissao() != null ? dto.getTipoDaMissao() : entity.getTipoDaMissao())
                .responsavelLocal(null)
                .coordenadorApostolico(null)
                .build();
    }

    public MissaoDTO toDTO(MissaoEntity entity) {
        return MissaoDTO
                .builder()
                .id(entity.getId())
                .nomeDaMissao(entity.getNomeDaMissao())
                .nivelDaMissao(entity.getNivelDaMissao())
                .tipoDaMissao(entity.getTipoDaMissao())
                .responsavelLocalId(null)
                .coordenadorApostolicoId(null)
                .build();
    }

    public List<MissaoDTO> toListDTO(List<MissaoEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
