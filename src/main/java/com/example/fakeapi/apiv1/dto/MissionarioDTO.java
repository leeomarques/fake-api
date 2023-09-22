package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionarioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomeCompleto")
    private String nomeCompleto;

    @JsonProperty("nivelFormativo")
    private String nivelFormativo;

    @JsonProperty("formacao")
    private String formacao;

    @JsonProperty("missao")
    private Long missao;

    @JsonProperty("ministerios")
    private List<Long> ministerios;

    @JsonProperty("formadorPessoalId")
    private Long formadorPessoal;

    @JsonProperty("formadorComunitarioId")
    private Long formadorComunitario;

    @JsonProperty("acompanhamentoComunitarioId")
    private Long acompanhamentoComunitario;

    @JsonProperty("reciclagens")
    private List<Long> reciclagens;

    @JsonProperty("foto")
    private String foto;

    @JsonProperty("historicos")
    private List<Long> historicos;

    @JsonProperty("dataInclusao")
    private LocalDateTime dataInclusao;

    @JsonProperty("dataAtualizacao")
    private LocalDateTime dataAtualizacao;
}