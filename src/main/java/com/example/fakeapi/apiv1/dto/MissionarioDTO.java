package com.example.fakeapi.apiv1.dto;

import com.example.fakeapi.infrastrucutre.entities.MissaoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private MissaoEntity missao;

    @JsonProperty("formadorPessoal")
    private Boolean formadorPessoal;

    @JsonProperty("formadorComunitario")
    private Boolean formadorComunitario;

    @JsonProperty("acompanhamentoComunitario")
    private Boolean acompanhamentoComunitario;

    @JsonProperty("foto")
    private String foto;

    @JsonProperty("dataInclusao")
    private LocalDateTime dataInclusao;

    @JsonProperty("dataAtualizacao")
    private LocalDateTime dataAtualizacao;
}