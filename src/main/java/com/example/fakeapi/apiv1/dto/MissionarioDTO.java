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
    private String missao;

    @JsonProperty("formadorPessoal")
    private Boolean formadorPessoal;

    @JsonProperty("formadorComunitario")
    private Boolean formadorComunitario;

    @JsonProperty("acompanhamentoComunitario")
    private Boolean acompanhamentoComunitario;

    @JsonProperty("foto")
    private String foto;

    @JsonProperty("reciclagens")
    private List<String> reciclagens;

    @JsonProperty("historicos")
    private List<String> historicos;

    @JsonProperty("ministerios")
    private List<String> ministerios;

    @JsonProperty("comunhaoDeBens")
    private List<String> comunhaoDeBens;

    @JsonProperty("dataInclusao")
    private LocalDateTime dataInclusao;

    @JsonProperty("dataAtualizacao")
    private LocalDateTime dataAtualizacao;
}