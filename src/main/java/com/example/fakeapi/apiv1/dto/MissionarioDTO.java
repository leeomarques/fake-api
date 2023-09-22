package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Blob;
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

    @JsonProperty("missaoId")
    private String missaoId;

    @JsonProperty("ministerios")
    private List<String> ministerios;

    @JsonProperty("formadorPessoalId")
    private String formadorPessoalId;

    @JsonProperty("formadorComunitarioId")
    private String formadorComunitarioId;

    @JsonProperty("acompanhamentoComunitarioId")
    private String acompanhamentoComunitarioId;

    @JsonProperty("historicoId")
    private String historicoId;

    @JsonProperty("foto")
    private Blob foto;

    @JsonProperty("reciclagem")
    private String reciclagem;

    @JsonProperty("dataInclusao")
    private LocalDateTime dataInclusao;

    @JsonProperty("dataAtualizacao")
    private LocalDateTime dataAtualizacao;
}
