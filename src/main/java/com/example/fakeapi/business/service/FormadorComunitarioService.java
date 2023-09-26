package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.FormadorComunitarioDTO;
import com.example.fakeapi.business.converter.FormadorComunitarioConverter;
import com.example.fakeapi.infrastrucutre.entities.FormadorComunitarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.FormadorComunitarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FormadorComunitarioService {

    private final FormadorComunitarioRepository repository;
    private final FormadorComunitarioConverter converter;

    public FormadorComunitarioEntity save(FormadorComunitarioEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }

    public FormadorComunitarioDTO saveDTO(FormadorComunitarioDTO dto) {
        try {
            FormadorComunitarioEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }


    public FormadorComunitarioDTO findById(Long id) {
        try {
            FormadorComunitarioEntity entity =
                    repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de " + "dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar o Missionário(a) por nome", id), e);
        }
    }

    public List<FormadorComunitarioDTO> findAll() {
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
            throw new RuntimeException(format("Erro ao deletar o Missionário(a)", id), e);
        }
    }

    public FormadorComunitarioDTO update(Long id, FormadorComunitarioDTO dto) {
        try {
            FormadorComunitarioEntity entity =
                    repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Missionário(a)"), e);
        }
    }

}
