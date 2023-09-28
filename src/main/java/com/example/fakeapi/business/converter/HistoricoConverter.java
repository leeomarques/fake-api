package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.HistoricoDTO;
import com.example.fakeapi.infrastrucutre.entities.HistoricoEntity;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HistoricoConverter {

    public final MissionarioRepository missionarioRepository;

    public HistoricoConverter(MissionarioRepository missionarioRepository) {
        this.missionarioRepository = missionarioRepository;
    }

    public HistoricoEntity toEntity(@NotNull HistoricoDTO dto) {
        var missionario = missionarioRepository
                .findById(dto.getMissionario())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));

        return HistoricoEntity
                .builder()
                .id(dto.getId())
                .pastoreio(dto.getPastoreio())
                .ano(dto.getAno())
                .observacoes(dto.getObservacoes())
                .missionario(missionario)
                .build();
    }

    public HistoricoEntity toEntityUpdate(HistoricoEntity entity, @NotNull HistoricoDTO dto, Long id) {
        MissionarioEntity missionario;

        if (dto.getId() != null) {
            missionario = missionarioRepository
                    .findById(dto.getMissionario())
                    .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + dto.getMissionario()));
        } else {
            missionario = entity.getMissionario();
        }

        return HistoricoEntity
                .builder()
                .id(id)
                .pastoreio(dto.getPastoreio() != null ? dto.getPastoreio() : entity.getPastoreio())
                .ano(dto.getAno() != null ? dto.getAno() : entity.getAno())
                .observacoes(dto.getObservacoes() != null ? dto.getObservacoes() : entity.getObservacoes())
                .missionario(missionario)
                .build();
    }

    public HistoricoDTO toDTO(@NotNull HistoricoEntity entity) {
        var missionario = missionarioRepository
                .findById(entity.getMissionario().getId())
                .orElseThrow(() -> new RuntimeException("Missionário não encontrado com ID: " + entity.getMissionario().getId()));

        return HistoricoDTO
                .builder()
                .id(entity.getId())
                .pastoreio(entity.getPastoreio())
                .ano(entity.getAno())
                .observacoes(entity.getObservacoes())
                .missionario(missionario.getId())
                .build();
    }

    public List<HistoricoDTO> toListDTO(@NotNull List<HistoricoEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
