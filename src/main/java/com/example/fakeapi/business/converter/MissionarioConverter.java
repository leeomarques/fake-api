package com.example.fakeapi.business.converter;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MissionarioConverter {

    public MissionarioEntity toEntity(MissionarioDTO dto) {
        return MissionarioEntity
                .builder()
                .id(dto.getId())
                .nomeCompleto(dto.getNomeCompleto())
                .nivelFormativo(dto.getNivelFormativo())
                .formacao(dto.getFormacao())
                .missao(null) // Você precisa implementar a lógica de mapeamento de ID da MissaoEntity
                .ministerios(null) // Você precisa implementar a lógica de mapeamento de IDs dos ministérios
                .formadorPessoal(null) // Você precisa implementar a lógica de mapeamento de ID da FormadorPessoalEntity
                .formadorComunitario(null) // Você precisa implementar a lógica de mapeamento de ID da FormadorComunitarioEntity
                .acompanhamentoComunitario(null) // Você precisa implementar a lógica de mapeamento de ID da AcompanhamentoComunitarioEntity
                .reciclagem(null) // Você precisa implementar a lógica de mapeamento de IDs das reciclagens
                .foto(dto.getFoto())
                .historicos(null) // Você precisa implementar a lógica de mapeamento de ID da HistoricoEntity
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
                .missao(null) // Você precisa implementar a lógica de mapeamento de ID da MissaoEntity
                .ministerios(null) // Você precisa implementar a lógica de mapeamento de IDs dos ministérios
                .formadorPessoal(null) // Você precisa implementar a lógica de mapeamento de ID da FormadorPessoalEntity
                .formadorComunitario(null) // Você precisa implementar a lógica de mapeamento de ID da FormadorComunitarioEntity
                .acompanhamentoComunitario(null) // Você precisa implementar a lógica de mapeamento de ID da AcompanhamentoComunitarioEntity
                .reciclagem(null) // Você precisa implementar a lógica de mapeamento de IDs das reciclagens
                .foto(dto.getFoto() != null ? dto.getFoto() : entity.getFoto())
                .historicos(null) // Você precisa implementar a lógica de mapeamento de ID da HistoricoEntity
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }


    public MissionarioDTO toDTO(MissionarioEntity entity) {
        return MissionarioDTO
                .builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .nivelFormativo(entity.getNivelFormativo())
                .formacao(entity.getFormacao())
                .missaoId(null) // Você precisa implementar a lógica de mapeamento do ID da MissaoEntity
                .ministerios(null) // Você precisa implementar a lógica de mapeamento dos IDs dos ministérios
                .formadorPessoalId(null) // Você precisa implementar a lógica de mapeamento do ID da FormadorPessoalEntity
                .formadorComunitarioId(null) // Você precisa implementar a lógica de mapeamento do ID da FormadorComunitarioEntity
                .acompanhamentoComunitarioId(null) // Você precisa implementar a lógica de mapeamento do ID da AcompanhamentoComunitarioEntity
                .reciclagem(null) // Você precisa implementar a lógica de mapeamento dos IDs das reciclagens
                .foto(entity.getFoto())
                .historicoId(null) // Você precisa implementar a lógica de mapeamento do ID da HistoricoEntity
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(entity.getDataAtualizacao())
                .build();
    }

    public List<MissionarioDTO> toListDTO(List<MissionarioEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
