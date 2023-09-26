package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.FormadorPessoalDTO;
import com.example.fakeapi.business.converter.FormadorPessoalConverter;
import com.example.fakeapi.infrastrucutre.entities.FormadorPessoalEntity;
import com.example.fakeapi.infrastrucutre.repositories.FormadorPessoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FormadorPessoalService {

    private final FormadorPessoalRepository repository;
    private final FormadorPessoalConverter converter;

    public FormadorPessoalEntity save(FormadorPessoalEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }

    public FormadorPessoalDTO saveDTO(FormadorPessoalDTO dto) {
        try {
            FormadorPessoalEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }


    public FormadorPessoalDTO findById(Long id) {
        try {
            FormadorPessoalEntity entity =
                    repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de " + "dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar o Missionário(a) por nome", id), e);
        }
    }

    public List<FormadorPessoalDTO> findAll() {
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


    public FormadorPessoalDTO update(Long id, FormadorPessoalDTO dto) {
        try {
            FormadorPessoalEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Missionário(a)"), e);
        }
    }

}
