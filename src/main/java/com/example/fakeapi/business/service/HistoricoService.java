package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.HistoricoDTO;
import com.example.fakeapi.business.converter.HistoricoConverter;
import com.example.fakeapi.infrastrucutre.entities.HistoricoEntity;
import com.example.fakeapi.infrastrucutre.repositories.HistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class HistoricoService {

    private final HistoricoRepository repository;
    private final HistoricoConverter converter;

    public HistoricoEntity save(HistoricoEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Histórico" + e);
        }
    }

    public HistoricoDTO saveDTO(HistoricoDTO dto) {
        try {
            HistoricoEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Histórico" + e);
        }
    }

    public List<HistoricoDTO> findAll() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos os Históricos"), e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar o Historico", id), e);
        }
    }

    public HistoricoDTO update(Long id, HistoricoDTO dto) {
        try {
            HistoricoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            entity = converter.toEntityUpdate(entity, dto, id);
            save(entity);

            return converter.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar o Histórico"), e);
        }
    }
}
