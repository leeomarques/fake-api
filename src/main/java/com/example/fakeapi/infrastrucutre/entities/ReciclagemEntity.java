package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
    @Column(name = "id")
    private Long id;

    @Column(name = "data_prevista")
    private LocalDate dataPrevista;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @ManyToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;


}
