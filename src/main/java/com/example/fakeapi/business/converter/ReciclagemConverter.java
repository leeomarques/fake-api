package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReciclagemConverter {

    public final MissionarioRepository missionarioRepository;

    public ReciclagemConverter(MissionarioRepository missionarioRepository) {
        this.missionarioRepository = missionarioRepository;
    }

    public ReciclagemEntity toEntity(@NotNull ReciclagemDTO dto) {
        var missionario = missionarioRepository
                .findById(dto.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));

        return ReciclagemEntity
                .builder()
                .id(dto.getId())
                .dataPrevista(dto.getDataPrevista())
                .dataConclusao(dto.getDataConclusao())
                .local(dto.getLocal())
                .missionario(missionario)
                .build();
    }

    public ReciclagemEntity toEntityUpdate(ReciclagemEntity entity, @NotNull ReciclagemDTO dto, Long id) {
        MissionarioEntity missionario;

        if (dto.getId() != null) {
            missionario = missionarioRepository
                    .findById(dto.getMissionario().getId())
                    .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));
        } else {
            missionario = entity.getMissionario();
        }

        return ReciclagemEntity
                .builder()
                .id(id)
                .dataPrevista(dto.getDataPrevista() != null ? dto.getDataPrevista() : entity.getDataPrevista())
                .dataConclusao(dto.getDataConclusao() != null ? dto.getDataConclusao() : entity.getDataConclusao())
                .local(dto.getLocal() != null ? dto.getLocal() : entity.getLocal())
                .missionario(missionario)
                .build();
    }

    public ReciclagemDTO toDTO(@NotNull ReciclagemEntity entity) {
        var missionario = missionarioRepository
                .findById(entity.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + entity.getMissionario().getId()));

        return ReciclagemDTO
                .builder()
                .id(entity.getId())
                .dataPrevista(entity.getDataPrevista())
                .dataConclusao(entity.getDataConclusao())
                .local(entity.getLocal())
                .missionario(MissionarioDTO.builder().build())
                .build();
    }

    public List<ReciclagemDTO> toListDTO(@NotNull List<ReciclagemEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
