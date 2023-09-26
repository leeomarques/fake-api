package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.AcompanhadoresComunitarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhadoresComunitarioRepository extends JpaRepository<AcompanhadoresComunitarioEntity, Long> {

    void deleteById(Long id);

}
