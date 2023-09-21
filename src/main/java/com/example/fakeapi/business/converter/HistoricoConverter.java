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
                .pastoreioMudancaDeNivel(dto.getPastoreioMudancaDeNivel())
                .ano(dto.getAno())
                .obs(dto.getObs())
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
