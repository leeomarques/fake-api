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
    @Column(name = "id")
    private String id;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "nivel_formativo")
    private String nivelFormativo;

    @Column(name = "formacao")
    private String formacao;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoEntity missao;

    @ManyToMany
    @JoinTable(name = "missionarios_ministerios", joinColumns = @JoinColumn(name = "missionario_id"),
               inverseJoinColumns = @JoinColumn(name = "ministerio_id"))
    private List<MinisterioEntity> ministerios;

    @OneToMany(mappedBy = "missionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComunhaoBensEntity> comunhoesDeBens;

    @ManyToOne
    @JoinColumn(name = "formador_pessoal_id")
    private FormadorPessoalEntity formadorPessoal;

    @ManyToOne
    @JoinColumn(name = "formador_comunitario_id")
    private FormadorComunitarioEntity formadorComunitario;

    @ManyToOne
    @JoinColumn(name = "acompanhamento_comunitario_id")
    private AcompanhamentoComunitarioEntity acompanhamentoComunitario;

    @OneToMany(mappedBy = "missionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReciclagemEntity> reciclagem;

    @Lob
    @Column(name = "foto", columnDefinition = "BLOB")
    private Blob foto;

    @ManyToOne
    @JoinColumn(name = "historico_id")
    private HistoricoEntity historico;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
