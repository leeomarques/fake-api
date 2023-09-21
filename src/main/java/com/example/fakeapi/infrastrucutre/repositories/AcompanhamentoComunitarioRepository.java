package com.example.fakeapi.infrastrucutre.repositories;

import com.example.fakeapi.infrastrucutre.entities.AcompanhamentoComunitarioEntity;
import com.example.fakeapi.infrastrucutre.entities.ComunhaoBensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhamentoComunitarioRepository extends JpaRepository<AcompanhamentoComunitarioEntity, String> {


}
