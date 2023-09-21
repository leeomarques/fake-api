package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.MinisterioEntity;
import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinisterioRepository extends JpaRepository<MinisterioEntity, String> {


}
