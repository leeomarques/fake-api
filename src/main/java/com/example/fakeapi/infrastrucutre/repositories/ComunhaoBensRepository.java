package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.ComunhaoBensEntity;
import com.example.fakeapi.infrastrucutre.entities.FormadorComunitarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunhaoBensRepository extends JpaRepository<ComunhaoBensEntity, Long> {


}
