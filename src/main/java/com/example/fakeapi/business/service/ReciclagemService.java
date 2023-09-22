package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.business.converter.ReciclagemConverter;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import com.example.fakeapi.infrastrucutre.repositories.ReciclagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ReciclagemService {

    private final ReciclagemRepository repository;
    private final ReciclagemConverter converter;

    public ReciclagemEntity save(ReciclagemEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Reciclagem" + e);
        }
    }

    public ReciclagemDTO saveDTO(ReciclagemDTO dto) {
        try {
            ReciclagemEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados da Reciclagem" + e);
        }
    }


    public ReciclagemDTO findById(Long id) {
        try {
            ReciclagemEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Reciclagem", id), e);
        }
    }

    public List<ReciclagemDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os Missionários(as)"), e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar os dados da Reciclagem", id), e);
        }
    }

    public Boolean existsById(Long id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar os dados da Reciclagem", id), e);
        }
    }

    public ReciclagemDTO update(Long id, ReciclagemDTO dto) {
        try {
            ReciclagemEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar os dados da Reciclagem"), e);
        }
    }
}
