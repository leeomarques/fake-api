package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ministerios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinisterioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ministerio_id")
    private Long id;

    @Column(name = "ministerio")
    private String ministerio;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "prioridade")
    private String prioridade;

    @ManyToOne
    @JoinColumn(name = "missionario_id", nullable = false)
    private MissionarioEntity missionario;


}
