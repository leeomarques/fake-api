package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "historico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pastoreio_mudanca_de_nivel")
    private String pastoreioMudancaDeNivel;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "obs")
    private String obs;

    @ManyToMany
    @JoinTable(name = "historico_ministerios", joinColumns = @JoinColumn(name = "historico_id"),
               inverseJoinColumns = @JoinColumn(name = "ministerio_id"))
    private List<MinisterioEntity> ministerios;

    @OneToMany(mappedBy = "historico")
    private List<MissionarioEntity> missionarios;

}
