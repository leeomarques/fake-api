package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "missionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @Column(name = "nivelFormativo")
    private String nivelFormativo;

    @Column(name = "formacao")
    private String formacao;

    @OneToOne
    @JoinColumn(name = "id_missao", referencedColumnName = "id", insertable = false, updatable = false)
    private MissaoEntity missao;

    @Column(name = "id_missao")
    private Long id_missao;

    @Column(name = "formadorPessoal")
    private Boolean formadorPessoal;

    @Column(name = "formadorComunitario")
    private Boolean formadorComunitario;

    @Column(name = "acompanhamentoComunitario")
    private Boolean acompanhamentoComunitario;

    @Lob
    @Column(name = "foto", columnDefinition = "BLOB")
    private Blob foto;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<ReciclagemEntity> reciclagens;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<HistoricoEntity> historicos;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<MinisterioEntity> ministerios;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<ComunhaoDeBensEntity> comunhaoDeBens;

    @Column(name = "dataInclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "dataAtualizacao")
    private LocalDateTime dataAtualizacao;

}
