package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
                .missao(dto.getMissao())
                .formadorPessoal(dto.getFormadorPessoal())
                .formadorComunitario(dto.getFormadorComunitario())
                .acompanhamentoComunitario(dto.getAcompanhamentoComunitario())
                .reciclagens(dto.getReciclagens())
                .foto(stringToBlob(dto.getFoto()))
                .historicos(dto.getHistoricos())
                .ministerios(dto.getMinisterios())
                .comunhaoDeBens(dto.getComunhaoDeBens())
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
                .missao(dto.getMissao() != null ? dto.getMissao() : entity.getMissao())
                .ministerios(dto.getMinisterios() != null ? dto.getMinisterios() : entity.getMinisterios())
                .formadorPessoal(dto.getFormadorPessoal() != null ? dto.getFormadorPessoal() : entity.getFormadorPessoal())
                .formadorComunitario(dto.getFormadorComunitario() != null ? dto.getFormadorComunitario() : entity.getFormadorComunitario())
                .acompanhamentoComunitario(
                        dto.getAcompanhamentoComunitario() != null ? dto.getAcompanhamentoComunitario() : entity.getAcompanhamentoComunitario())
                .reciclagens(dto.getReciclagens() != null ? dto.getReciclagens() : entity.getReciclagens())
                .foto(dto.getFoto() != null ? stringToBlob(dto.getFoto()) : entity.getFoto())
                .historicos(dto.getHistoricos() != null ? dto.getHistoricos() : entity.getHistoricos())
                .dataInclusao(dto.getDataInclusao() != null ? dto.getDataInclusao() : entity.getDataInclusao())
                .dataAtualizacao(dto.getDataAtualizacao() != null ? dto.getDataAtualizacao() : entity.getDataAtualizacao())
                .build();

    }


    public MissionarioDTO toDTO(MissionarioEntity entity) {
        return MissionarioDTO
                .builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .nivelFormativo(entity.getNivelFormativo())
                .formacao(entity.getFormacao())
                .missao(entity.getMissao())
                .formadorPessoal(entity.getFormadorPessoal())
                .formadorComunitario(entity.getFormadorComunitario())
                .acompanhamentoComunitario(entity.getAcompanhamentoComunitario())
                .reciclagens(entity.getReciclagens())
                .foto(blobToString(entity.getFoto()))
                .historicos(entity.getHistoricos())
                .dataInclusao(LocalDateTime.now())
                .dataAtualizacao(entity.getDataAtualizacao())
                .build();

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
