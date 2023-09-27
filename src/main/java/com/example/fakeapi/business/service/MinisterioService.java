package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.MinisterioDTO;
import com.example.fakeapi.business.converter.MinisterioConverter;
import com.example.fakeapi.infrastrucutre.entities.MinisterioEntity;
import com.example.fakeapi.infrastrucutre.repositories.MinisterioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MinisterioService {

    private final MinisterioRepository repository;
    private final MinisterioConverter converter;

    public MinisterioEntity save(MinisterioEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Ministério" + e);
        }
    }

    public MinisterioDTO saveDTO(MinisterioDTO dto) {
        try {
            MinisterioEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Ministério" + e);
        }
    }

    public List<MinisterioDTO> findAll() {
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
            throw new RuntimeException(format("Erro ao deletar o Ministério", id), e);
        }
    }

    public MinisterioDTO update(Long id, MinisterioDTO dto) {
        try {
            MinisterioEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Ministério"), e);
        }
    }
}
