package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "missao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeMissao")
    private String nomeMissao;

    @OneToOne
    @JoinColumn(name = "responsavel_local_id", referencedColumnName = "id")
    private MissionarioEntity responsavelLocal;

    @OneToOne
    @JoinColumn(name = "coordenador_apostolico_id", referencedColumnName = "id")
    private MissionarioEntity coordenadorApostolico;

}
