package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_id")
    private Long id;

    @Column(name = "pastoreio")
    private String pastoreio;

    @Column(name = "ano")
    private String ano;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;


}
