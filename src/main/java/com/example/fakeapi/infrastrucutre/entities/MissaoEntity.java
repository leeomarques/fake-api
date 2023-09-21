package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "missao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_da_missao")
    private String nomeDaMissao;

    @Column(name = "nivel_da_missao")
    private String nivelDaMissao;

    @Column(name = "tipo_da_missao")
    private String tipoDaMissao;

    @ManyToOne
    @JoinColumn(name = "responsavel_local_id")
    private MissionarioEntity responsavelLocal;

    @ManyToOne
    @JoinColumn(name = "coordenador_apostolico_id")
    private MissionarioEntity coordenadorApostolico;

}
