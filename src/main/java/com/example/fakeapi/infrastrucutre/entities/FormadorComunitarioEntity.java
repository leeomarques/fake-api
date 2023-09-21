package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "formadores_comunitarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormadorComunitarioEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

}
