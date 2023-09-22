package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.MissaoDTO;
import com.example.fakeapi.business.converter.MissaoConverter;
import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import com.example.fakeapi.infrastrucutre.repositories.MissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MissaoService {

    private final MissaoRepository repository;
    private final MissaoConverter converter;

    public MissaoEntity save(MissaoEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Missão" + e);
        }
    }

    public MissaoDTO saveDTO(MissaoDTO dto) {
        try {
            MissaoEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Missão" + e);
        }
    }


    public MissaoDTO findById(Long id) {
        try {
            MissaoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Missão", id), e);
        }
    }

    public List<MissaoDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os dados da Missão"), e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar os dados da Missão", id), e);
        }
    }

    public Boolean existsById(Long id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Missão", id), e);
        }
    }

    public MissaoDTO update(Long id, MissaoDTO dto) {
        try {
            MissaoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar os dados da Missão"), e);
        }
    }
}
