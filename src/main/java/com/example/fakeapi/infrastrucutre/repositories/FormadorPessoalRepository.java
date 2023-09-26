package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.FormadorPessoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormadorPessoalRepository extends JpaRepository<FormadorPessoalEntity, Long> {

    void deleteById(Long id);

}
