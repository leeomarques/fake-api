package com.example.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {

    @JsonIgnore
    private String id;

    private String entityId;

    private String nome;

    private BigDecimal preco;

    private String categoria;

    private String descricao;

    private String imagem;
}
