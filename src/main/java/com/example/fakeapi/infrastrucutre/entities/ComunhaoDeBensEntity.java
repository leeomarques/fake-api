package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comunhao_de_bens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunhaoDeBensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dezPorcentos")
    private Double dezPorcentos;

    @Column(name = "cincoPorcentos")
    private Double cincoPorcentos;

    @Column(name = "observacoes")
    private String observacoes;

    @OneToOne
    @JoinColumn(name = "missionario", referencedColumnName = "id")
    private MissionarioEntity missionario;
}
