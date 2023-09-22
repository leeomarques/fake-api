package com.example.fakeapi.infrastrucutre.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "acompanhadores_comunitarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompanhamentoComunitarioEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "missionario_id")
    private MissionarioEntity missionario;

}
