package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MinisterioDTO;
import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.infrastrucutre.entities.MinisterioEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MinisterioConverter {

    public final MissionarioRepository missionarioRepository;

    public MinisterioConverter(MissionarioRepository missionarioRepository) {
        this.missionarioRepository = missionarioRepository;
    }

    public MinisterioEntity toEntity(@NotNull MinisterioDTO dto) {
        var missionario = missionarioRepository
                .findById(dto.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));

        return MinisterioEntity
                .builder()
                .id(dto.getId())
                .ministerio(dto.getMinisterio())
                .tipo(dto.getTipo())
                .prioridade(dto.getPrioridade())
                .missionario(missionario)
                .build();
    }

    public MinisterioEntity toEntityUpdate(MinisterioEntity entity, @NotNull MinisterioDTO dto, Long id) {
        MissionarioEntity missionario;

        if (dto.getId() != null) {
            missionario = missionarioRepository
                    .findById(dto.getMissionario().getId())
                    .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));
        } else {
            missionario = entity.getMissionario();
        }

        return MinisterioEntity
                .builder()
                .id(id)
                .ministerio(dto.getMinisterio() != null ? dto.getMinisterio() : entity.getMinisterio())
                .tipo(dto.getTipo() != null ? dto.getTipo() : entity.getTipo())
                .prioridade(dto.getPrioridade() != null ? dto.getPrioridade() : entity.getPrioridade())
                .missionario(missionario)
                .build();
    }

    public MinisterioDTO toDTO(@NotNull MinisterioEntity entity) {
        var missionario = missionarioRepository
                .findById(entity.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + entity.getMissionario().getId()));

        return MinisterioDTO
                .builder()
                .id(entity.getId())
                .ministerio(entity.getMinisterio())
                .tipo(entity.getTipo())
                .prioridade(entity.getPrioridade())
                .missionario(MissionarioDTO.builder().build())
                .build();
    }

    public List<MinisterioDTO> toListDTO(@NotNull List<MinisterioEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
