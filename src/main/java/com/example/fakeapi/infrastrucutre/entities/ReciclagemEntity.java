package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reciclagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReciclagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reciclagem_id")
    private Long id;

    @Column(name = "dataPrevista")
    private LocalDateTime dataPrevista;

    @Column(name = "dataConclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "local")
    private String local;

    @ManyToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;


}
