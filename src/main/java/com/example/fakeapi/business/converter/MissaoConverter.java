package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissaoDTO;
import com.example.fakeapi.infrastrucutre.Exceptions.EntityNotFoundException;
import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissaoConverter {

    public final MissionarioRepository missionarioRepository;

    public MissaoConverter(MissionarioRepository missionarioRepository) {
        this.missionarioRepository = missionarioRepository;
    }

    public MissaoEntity toEntity(@NotNull MissaoDTO dto) {

        var rl = missionarioRepository
                .findById(dto.getResponsavelLocal().getId())
                .orElseThrow(() -> new EntityNotFoundException("MissionarioEntity", dto.getResponsavelLocal().getId()));
        var cap = missionarioRepository
                .findById(dto.getCoordenadorApostolico().getId())
                .orElseThrow(() -> new EntityNotFoundException("MissionarioEntity", dto.getResponsavelLocal().getId()));

        return MissaoEntity.builder().nomeMissao(dto.getNomeMissao()).responsavelLocal(rl).coordenadorApostolico(cap).build();
    }

    public MissaoEntity toEntityUpdate(MissaoEntity entity, @NotNull MissaoDTO dto, Long id) {

        var rl = missionarioRepository
                .findById(dto.getResponsavelLocal().getId())
                .orElseThrow(() -> new EntityNotFoundException("MissionarioEntity", dto.getResponsavelLocal().getId()));
        var cap = missionarioRepository
                .findById(dto.getCoordenadorApostolico().getId())
                .orElseThrow(() -> new EntityNotFoundException("MissionarioEntity", dto.getResponsavelLocal().getId()));

        return MissaoEntity
                .builder()
                .id(id)
                .nomeMissao(dto.getNomeMissao() != null ? dto.getNomeMissao() : entity.getNomeMissao())
                .responsavelLocal(rl)
                .coordenadorApostolico(cap)
                .build();
    }

    public MissaoDTO toDTO(@NotNull MissaoEntity entity) {

        return MissaoDTO
                .builder()
                .id(entity.getId())
                .nomeMissao(entity.getNomeMissao())
                .responsavelLocal(entity.getResponsavelLocal())
                .coordenadorApostolico(entity.getCoordenadorApostolico())
                .build();
    }

    public List<MissaoDTO> toListDTO(@NotNull List<MissaoEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
