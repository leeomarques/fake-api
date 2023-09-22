package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ministerios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinisterioEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "prioridade")
    private String prioridade;

    @ManyToMany(mappedBy = "ministerios")
    private List<MissionarioEntity> missionarios;

}
