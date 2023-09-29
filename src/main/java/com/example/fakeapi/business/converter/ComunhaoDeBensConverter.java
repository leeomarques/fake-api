package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.ComunhaoDeBensDTO;
import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoDeBensEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComunhaoDeBensConverter {

    public final MissionarioRepository missionarioRepository;

    public ComunhaoDeBensConverter(MissionarioRepository missionarioRepository) {
        this.missionarioRepository = missionarioRepository;
    }

    public ComunhaoDeBensEntity toEntity(@NotNull ComunhaoDeBensDTO dto) {
        var missionario = missionarioRepository
                .findById(dto.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));

        return ComunhaoDeBensEntity
                .builder()
                .id(dto.getId())
                .dezPorcentos(dto.getDezPorcentos())
                .cincoPorcentos(dto.getCincoPorcentos())
                .observacoes(dto.getObservacoes())
                .missionario(missionario)
                .build();
    }

    public ComunhaoDeBensEntity toEntityUpdate(ComunhaoDeBensEntity entity, @NotNull ComunhaoDeBensDTO dto, Long id) {
        MissionarioEntity missionario;

        if (dto.getId() != null) {
            missionario = missionarioRepository
                    .findById(dto.getMissionario().getId())
                    .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));
        } else {
            missionario = entity.getMissionario();
        }

        return ComunhaoDeBensEntity
                .builder()
                .id(id)
                .dezPorcentos(dto.getDezPorcentos() != null ? dto.getDezPorcentos() : entity.getDezPorcentos())
                .cincoPorcentos(dto.getCincoPorcentos() != null ? dto.getCincoPorcentos() : entity.getCincoPorcentos())
                .observacoes(dto.getObservacoes() != null ? dto.getObservacoes() : entity.getObservacoes())
                .missionario(missionario)
                .build();
    }

    public ComunhaoDeBensDTO toDTO(@NotNull ComunhaoDeBensEntity entity) {
        var missionario = missionarioRepository
                .findById(entity.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + entity.getMissionario().getId()));

        return ComunhaoDeBensDTO
                .builder()
                .id(entity.getId())
                .dezPorcentos(entity.getDezPorcentos())
                .cincoPorcentos(entity.getCincoPorcentos())
                .observacoes(entity.getObservacoes())
                .missionario(MissionarioDTO.builder().build())
                .build();
    }

    public List<ComunhaoDeBensDTO> toListDTO(@NotNull List<ComunhaoDeBensEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
