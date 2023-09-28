package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "missionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "missionario_id")
    private Long id;

    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @Column(name = "nivelFormativo")
    private String nivelFormativo;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "missao")
    private String missao;

    @Column(name = "formadorPessoal")
    private Boolean formadorPessoal;

    @Column(name = "formadorComunitario")
    private Boolean formadorComunitario;

    @Column(name = "acompanhamentoComunitario")
    private Boolean acompanhamentoComunitario;

    @Lob
    @Column(name = "foto", columnDefinition = "BLOB")
    private Blob foto;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "reciclagens", joinColumns = @JoinColumn(name = "missionario_id"))
    @Column(name = "reciclagem")
    private List<String> reciclagens;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<HistoricoEntity> historicos;

    @OneToMany(mappedBy = "missionario", fetch = FetchType.EAGER)
    private List<MinisterioEntity> ministerios;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "comunhaoDeBens", joinColumns = @JoinColumn(name = "missionario_id"))
    @Column(name = "comunhaoDeBens")
    private List<String> comunhaoDeBens;

    @Column(name = "dataInclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "dataAtualizacao")
    private LocalDateTime dataAtualizacao;

}
