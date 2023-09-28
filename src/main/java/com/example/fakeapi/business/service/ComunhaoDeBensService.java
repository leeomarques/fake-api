package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.ComunhaoDeBensDTO;
import com.example.fakeapi.business.converter.ComunhaoDeBensConverter;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoDeBensEntity;
import com.example.fakeapi.infrastrucutre.repositories.ComunhaoDeBensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ComunhaoDeBensService {

    private final ComunhaoDeBensRepository repository;
    private final ComunhaoDeBensConverter converter;

    public ComunhaoDeBensEntity save(ComunhaoDeBensEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Comunhão de Bens" + e);
        }
    }

    public ComunhaoDeBensDTO saveDTO(ComunhaoDeBensDTO dto) {
        try {
            ComunhaoDeBensEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Comunhão de Bens" + e);
        }
    }

    public List<ComunhaoDeBensDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os Registros"), e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar o Registro", id), e);
        }
    }

    public ComunhaoDeBensDTO update(Long id, ComunhaoDeBensDTO dto) {
        try {
            ComunhaoDeBensEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar a Comunhão de Bens"), e);
        }
    }
}
