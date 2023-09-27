package com.example.fakeapi.apiv1.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionarioDTO {

    private Long id;

    private String nomeCompleto;

    private String nivelFormativo;

    private String formacao;

    private String missao;

    private Boolean formadorPessoal;

    private Boolean formadorComunitario;

    private Boolean acompanhamentoComunitario;

    private String foto;

    private List<String> reciclagens;

    private List<String> historicos;

    private List<Long> ministerios;

    private List<String> comunhaoDeBens;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAtualizacao;
}