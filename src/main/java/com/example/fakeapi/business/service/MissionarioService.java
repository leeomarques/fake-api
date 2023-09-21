package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.business.converter.MissionarioConverter;
import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MissionarioService {

    private final MissionarioRepository repository;
    private final MissionarioConverter converter;

    public MissionarioEntity save(MissionarioEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }

    public MissionarioDTO saveDTO(MissionarioDTO dto) {
        try {
            MissionarioEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }


    public MissionarioDTO findByName(String nome) {
        try {
            return converter.toDTO(repository.findByNomeCompleto(nome));
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar o Missionário(a) por nome", nome), e);
        }
    }

    public List<MissionarioDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os Missionários(as)"), e);
        }
    }

    public void delete(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar o Missionário(a)", id), e);
        }
    }

    public Boolean existsByName(String nome) {
        try {
            return repository.existsByNomeCompleto(nome);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar o Missionário(a) por nome", nome), e);
        }
    }

    public MissionarioDTO update(String id, MissionarioDTO dto) {
        try {
            MissionarioEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            save(converter.toEntityUpdate(entity, dto, id));
            return converter.toDTO(repository.findByNomeCompleto(entity.getNomeCompleto()));
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Missionário(a)"), e);
        }
    }
}
