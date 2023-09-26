package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.AcompanhadoresComunitarioDTO;
import com.example.fakeapi.business.converter.AcompanhamentoComunitarioConverter;
import com.example.fakeapi.infrastrucutre.entities.AcompanhadoresComunitarioEntity;
import com.example.fakeapi.infrastrucutre.repositories.AcompanhadoresComunitarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AcompanhadoresComunitarioService {

    @Autowired
    private final AcompanhadoresComunitarioRepository repository;

    private final AcompanhamentoComunitarioConverter converter;

    @Transactional
    public AcompanhadoresComunitarioEntity save(AcompanhadoresComunitarioEntity entity) {
        try {
            return repository.saveAndFlush(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }

    public AcompanhadoresComunitarioDTO saveDTO(AcompanhadoresComunitarioDTO dto) {
        try {
            AcompanhadoresComunitarioEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Missionário(a)" + e);
        }
    }


    public AcompanhadoresComunitarioDTO findById(Long id) {
        try {
            AcompanhadoresComunitarioEntity entity =
                    repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de " + "dados"));
            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar o Missionário(a) por nome", id), e);
        }
    }

    public List<AcompanhadoresComunitarioDTO> findAll() {
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

    public AcompanhadoresComunitarioDTO update(Long id, AcompanhadoresComunitarioDTO dto) {
        try {
            AcompanhadoresComunitarioEntity entity =
                    repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Missionário(a)"), e);
        }
    }

}
