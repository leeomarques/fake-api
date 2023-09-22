package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.HistoricoDTO;
import com.example.fakeapi.infrastrucutre.entities.HistoricoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoricoConverter {

    public HistoricoEntity toEntity(HistoricoDTO dto) {
        return HistoricoEntity
                .builder()
                .id(dto.getId())
                .pastoreioMudancaDeNivel(dto.getPastoreioMudancaDeNivel())
                .ano(dto.getAno())
                .obs(dto.getObs())
                .ministerios(null)
                .missionario(null)
                .build();
    }

    public HistoricoEntity toEntityUpdate(HistoricoEntity entity, HistoricoDTO dto, Long id) {
        return HistoricoEntity
                .builder()
                .id(id)
                .pastoreioMudancaDeNivel(
                        dto.getPastoreioMudancaDeNivel() != null ? dto.getPastoreioMudancaDeNivel() : entity.getPastoreioMudancaDeNivel())
                .ano(dto.getAno() != null ? dto.getAno() : entity.getAno())
                .obs(dto.getObs() != null ? dto.getObs() : entity.getObs())
                .ministerios(null)
                .missionario(null)
                .build();
    }

    public HistoricoDTO toDTO(HistoricoEntity entity) {
        return HistoricoDTO
                .builder()
                .pastoreioMudancaDeNivel(entity.getPastoreioMudancaDeNivel())
                .ano(entity.getAno())
                .obs(entity.getObs())
                .build();
    }

    public List<HistoricoDTO> toListDTO(List<HistoricoEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
