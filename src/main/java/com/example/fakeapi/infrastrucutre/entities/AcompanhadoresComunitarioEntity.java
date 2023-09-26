package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "acompanhadores_comunitarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompanhadoresComunitarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "missionario_id", nullable = true)
    private MissionarioEntity missionario;

}
