package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.infrastrucutre.entities.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionarioConverter {

    private final ReciclagemConverter reciclagemConverter;
    private final HistoricoConverter historicoConverter;

    public MissionarioConverter(ReciclagemConverter reciclagemConverter, HistoricoConverter historicoConverter) {
        this.reciclagemConverter = reciclagemConverter;
        this.historicoConverter = historicoConverter;
    }

    public MissionarioEntity toEntity(MissionarioDTO dto) {
        return MissionarioEntity
                .builder()
                .id(dto.getId())
                .nomeCompleto(dto.getNomeCompleto())
                .nivelFormativo(dto.getNivelFormativo())
                .formacao(dto.getFormacao())
                .missao(MissaoEntity.builder().build())
                .ministerios(Collections.singletonList(MinisterioEntity.builder().build()))
                .formadorPessoal(FormadorPessoalEntity.builder().build())
                .formadorComunitario(FormadorComunitarioEntity.builder().build())
                .acompanhadorComunitario(AcompanhamentoComunitarioEntity.builder().build())
                .reciclagem(Collections.singletonList(ReciclagemEntity.builder().build()))
                .foto(stringToBlob(dto.getFoto()))
                .historicos(Collections.singletonList((HistoricoEntity.builder().build())))
                .dataInclusao(dto.getDataInclusao())
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
                .acompanhadorComunitario(null)
                .reciclagem(null)
                .foto(dto.getFoto() != null ? stringToBlob(dto.getFoto()) : entity.getFoto())
                .historicos(null)
                .dataInclusao(dto.getDataInclusao() != null ? dto.getDataInclusao() : entity.getDataInclusao())
                .dataAtualizacao(dto.getDataAtualizacao() != null ? dto.getDataAtualizacao() : entity.getDataAtualizacao())
                .build();

    }


    public MissionarioDTO toDTO(MissionarioEntity entity) {
        MissionarioDTO dto = MissionarioDTO
                .builder()
                .id(entity.getId())
                .nomeCompleto(getValueOrNull(entity.getNomeCompleto()))
                .nivelFormativo(getValueOrNull(entity.getNivelFormativo()))
                .formacao(getValueOrNull(entity.getFormacao()))
                .foto(blobToString(entity.getFoto()))
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(entity.getDataAtualizacao())
                .missao(entity.getMissao() != null ? entity.getMissao().getId() : null)
                .formadorPessoal(entity.getFormadorPessoal() != null ? entity.getFormadorPessoal().getId() : null)
                .formadorComunitario(entity.getFormadorComunitario() != null ? entity.getFormadorComunitario().getId() : null)
                .acompanhamentoComunitario(entity.getAcompanhadorComunitario() != null ? entity.getAcompanhadorComunitario().getId() : null)
                .reciclagens(null)
                .historicos(null)
                .build();

        return dto;
    }

    private String getValueOrNull(String value) {
        return value != null ? value : null;
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
