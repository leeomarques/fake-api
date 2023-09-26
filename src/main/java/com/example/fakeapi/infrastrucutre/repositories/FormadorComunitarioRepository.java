package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.FormadorComunitarioEntity;
import com.example.fakeapi.infrastrucutre.entities.FormadorPessoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormadorComunitarioRepository extends JpaRepository<FormadorComunitarioEntity, Long> {

    void deleteById(Long id);
}
