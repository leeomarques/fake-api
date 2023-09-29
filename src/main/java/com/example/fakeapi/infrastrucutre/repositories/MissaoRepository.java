package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.HistoricoEntity;
import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<MissaoEntity, Long> {

    void deleteById(Long id);

}
