package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.ComunhaoDeBensEntity;
import com.example.fakeapi.infrastrucutre.entities.HistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunhaoDeBensRepository extends JpaRepository<ComunhaoDeBensEntity, Long> {

    void deleteById(Long id);

}
