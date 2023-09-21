package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.entities.ProdutoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionarioRepository extends JpaRepository<MissionarioEntity, String> {

    Boolean existsByNomeCompleto(String nome);

    MissionarioEntity findByNomeCompleto(String nome);

    void deleteById(String id);

}
