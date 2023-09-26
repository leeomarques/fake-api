package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.*;
import com.example.fakeapi.infrastrucutre.entities.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionarioConverter {


    public MissionarioEntity toEntity(MissionarioDTO dto) {

        return MissionarioEntity
                .builder()
                .id(dto.getId())
                .nomeCompleto(dto.getNomeCompleto())
                .nivelFormativo(dto.getNivelFormativo())
                .formacao(dto.getFormacao())
                .missao(MissaoEntity.builder().id(dto.getMissao()).build())
                .ministerios(dto.getMinisterios().stream().map(ministerioId -> {
                    MinisterioEntity ministerioEntity = new MinisterioEntity();
                    ministerioEntity.setId(ministerioId);
                    return ministerioEntity;
                }).collect(Collectors.toList()))
                .formadorPessoal(FormadorPessoalEntity.builder().id(dto.getFormadorPessoal()).build())
                .formadorComunitario(FormadorComunitarioEntity.builder().id(dto.getFormadorComunitario()).build())
                .acompanhamentoComunitario(AcompanhadoresComunitarioEntity.builder().id(dto.getAcompanhamentoComunitario()).build())
                .reciclagem(dto.getReciclagens().stream().map(reciclagemId -> {
                    ReciclagemEntity reciclagemEntity = new ReciclagemEntity();
                    reciclagemEntity.setId(reciclagemId);
                    return reciclagemEntity;
                }).collect(Collectors.toList()))
                .foto(stringToBlob(dto.getFoto()))
                .historicos(dto.getHistoricos().stream().map(historicoId -> {
                    HistoricoEntity historicoEntity = new HistoricoEntity();
                    historicoEntity.setId(historicoId);
                    return historicoEntity;
                }).collect(Collectors.toList()))
                .dataInclusao(LocalDateTime.now())
                .dataAtualizacao(dto.getDataAtualizacao())
                .build();
    }


    public MissionarioEntity toEntityUpdate(MissionarioEntity entity, MissionarioDTO dto, Long id) {
        return MissionarioEntity
                .builder()
                .id(id)
                .nomeCompleto(dto.getNomeCompleto() != null ? dto.getNomeCompleto() : entity.getNomeCompleto())
                .nivelFormativo(dto.getNivelFormativo() != null ? dto.getNivelFormativo() : entity.getNivelFormativo())
                .formacao(dto.getFormacao() != null ? dto.getFormacao() : entity.getFormacao())
                .missao(dto.getMissao() != null ? MissaoEntity.builder().build() : entity.getMissao())
                .ministerios(dto.getMinisterios() != null ?
                                     dto
                                             .getMinisterios()
                                             .stream()
                                             .map(me -> MinisterioEntity.builder().id(id).build())
                                             .collect(Collectors.toList()) :
                                     entity.getMinisterios())
                .formadorPessoal(null)
                .formadorComunitario(null)
                .acompanhamentoComunitario(null)
                .reciclagem(null)
                .foto(dto.getFoto() != null ? stringToBlob(dto.getFoto()) : entity.getFoto())
                .historicos(null)
                .dataInclusao(dto.getDataInclusao() != null ? dto.getDataInclusao() : entity.getDataInclusao())
                .dataAtualizacao(dto.getDataAtualizacao() != null ? dto.getDataAtualizacao() : entity.getDataAtualizacao())
                .build();

    }


    public MissionarioDTO toDTO(MissionarioEntity entity) {
        MissaoDTO missaoDTO = new MissaoDTO();
        MinisterioDTO ministerioDTO = new MinisterioDTO();
        ReciclagemDTO reciclagemDTO = new ReciclagemDTO();
        HistoricoDTO historicoDTO = new HistoricoDTO();
        FormadorPessoalDTO formadorPessoalDTO = new FormadorPessoalDTO();
        FormadorComunitarioDTO formadorComunitarioDTO = new FormadorComunitarioDTO();
        AcompanhadoresComunitarioDTO acompanhamentoComunitarioDTO = new AcompanhadoresComunitarioDTO();


        MissionarioDTO missionarioDTO = MissionarioDTO
                .builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .nivelFormativo(entity.getNivelFormativo())
                .formacao(entity.getFormacao())
                .foto(blobToString(entity.getFoto()))
                .dataInclusao(LocalDateTime.now())
                .dataAtualizacao(entity.getDataAtualizacao())
                .build();

        if (missaoDTO.getId() != null) {
            missionarioDTO.setMissao(missaoDTO.getId());
        }

        if (formadorPessoalDTO.getMissionario() != null) {
            missionarioDTO.setFormadorPessoal(formadorPessoalDTO.getMissionario().getId());
        }

        if (formadorComunitarioDTO.getMissionario() != null) {
            missionarioDTO.setFormadorComunitario(formadorComunitarioDTO.getMissionario().getId());
        }

        if (acompanhamentoComunitarioDTO.getMissionario() != null) {
            missionarioDTO.setAcompanhamentoComunitario(acompanhamentoComunitarioDTO.getMissionario().getId());
        }

        if (reciclagemDTO.getId() != null) {
            missionarioDTO.setReciclagens(Collections.singletonList(reciclagemDTO.getId()));
        }

        if (historicoDTO.getId() != null) {
            missionarioDTO.setHistoricos(Collections.singletonList(historicoDTO.getId()));
        }

        if (ministerioDTO.getId() != null) {
            missionarioDTO.setMinisterios(Collections.singletonList(ministerioDTO.getId()));
        }

        return missionarioDTO;

    }

    public List<MissionarioDTO> toListDTO(List<MissionarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Blob stringToBlob(String content) {
        if (content != null) {
            try {
                byte[] bytes = content.getBytes("UTF-8");
                InputStream inputStream = new ByteArrayInputStream(bytes);
                return new javax.sql.rowset.serial.SerialBlob(bytes);
            } catch (SQLException | java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String blobToString(Blob blob) {
        try {
            if (blob != null) {
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] content = outputStream.toByteArray();
                return new String(content, "UTF-8");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
