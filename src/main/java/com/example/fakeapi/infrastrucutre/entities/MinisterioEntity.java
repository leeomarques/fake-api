package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ministerios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinisterioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ministerio")
    private String ministerio;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "prioridade")
    private String prioridade;

    @OneToOne
    @JoinColumn(name = "missionario", referencedColumnName = "id")
    private MissionarioEntity missionario;


}
