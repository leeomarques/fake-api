package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.ComunhaoBensDTO;
import com.example.fakeapi.business.converter.ComunhaoBensConverter;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoBensEntity;
import com.example.fakeapi.infrastrucutre.repositories.ComunhaoBensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ComunhaoBensService {

    private final ComunhaoBensRepository repository;
    private final ComunhaoBensConverter converter;

    public ComunhaoBensEntity save(ComunhaoBensEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Comunhão de Bens" + e);
        }
    }

    public ComunhaoBensDTO saveDTO(ComunhaoBensDTO dto) {
        try {
            ComunhaoBensEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Comunhão de Bens" + e);
        }
    }


    public ComunhaoBensDTO findById(Long id) {
        try {
            ComunhaoBensEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Comunhão de Bens", id), e);
        }
    }

    public List<ComunhaoBensDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os dados da Comunhão de Bens"), e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar os dados da Comunhão de Bens", id), e);
        }
    }

    public Boolean existsById(Long id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Comunhão de Bens", id), e);
        }
    }

    public ComunhaoBensDTO update(Long id, ComunhaoBensDTO dto) {
        try {
            ComunhaoBensEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar os dados da Comunhão de Bens"), e);
        }
    }
}
