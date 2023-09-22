    package com.example.fakeapi.infrastrucutre.entities;

    import jakarta.persistence.*;
    import lombok.*;


    @Entity
    @Table(name = "formadores_comunitarios")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class FormadorComunitarioEntity {

        @Id
        @Column(name = "id")
        private Long id;

        @OneToOne
        @JoinColumn(name = "missionario_id")
        private MissionarioEntity missionario;

    }
