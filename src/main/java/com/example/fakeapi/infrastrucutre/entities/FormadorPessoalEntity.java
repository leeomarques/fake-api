package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "formadores_pessoais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormadorPessoalEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;


}
