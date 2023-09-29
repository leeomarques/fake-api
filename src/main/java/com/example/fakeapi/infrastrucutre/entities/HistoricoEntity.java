package com.example.fakeapi.infrastrucutre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pastoreio")
    private String pastoreio;

    @Column(name = "ano")
    private String ano;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "missionario_id", referencedColumnName = "id")
    private MissionarioEntity missionario;

    @Column(name = "missionario_id", insertable = false, updatable = false) // Add this line
    private Long missionarioId; // This field is used to map to the 'id' column without conflicting with the 'missionario' property.
}