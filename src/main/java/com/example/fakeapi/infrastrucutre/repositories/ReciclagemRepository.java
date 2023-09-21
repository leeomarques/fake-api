package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.MissionarioEntity;
import com.example.fakeapi.infrastrucutre.entities.ReciclagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciclagemRepository extends JpaRepository<ReciclagemEntity, Long> {


}
