package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "comunhao_bens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunhaoBensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;

    @Column(name = "valor_10_percent")
    private BigDecimal valor10Percent;

    @Column(name = "valor_5_percent")
    private BigDecimal valor5Percent;

    @Column(name = "mes_referencia")
    private String mesReferencia;

    @Column(name = "ano_referencia")
    private String anoReferencia;

    @Column(name = "situacao")
    private String situacao;

}
