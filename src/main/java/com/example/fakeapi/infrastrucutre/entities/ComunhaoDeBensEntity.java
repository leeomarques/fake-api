package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comunhao_de_bens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunhaoDeBensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comunhao_de_bens_id")
    private Long id;

    @Column(name = "dezPorcentos")
    private Double dezPorcentos;

    @Column(name = "cincoPorcentos")
    private Double cincoPorcentos;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;


}
