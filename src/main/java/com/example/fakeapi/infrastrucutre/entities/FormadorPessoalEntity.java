package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;

}
