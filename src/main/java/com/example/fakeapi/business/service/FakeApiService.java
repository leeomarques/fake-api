package com.example.fakeapi.business.service;

import com.example.fakeapi.apiv1.dto.ProductsDTO;
import com.example.fakeapi.business.converter.ProdutoConverter;
import com.example.fakeapi.business.service.ProdutoService;
import com.example.fakeapi.infrastrucutre.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;
    private final ProdutoConverter converter;
    private final ProdutoService produtoService;


    public List<ProductsDTO> buscaProdutos() {
        try {
            List<ProductsDTO> dto = cliente.buscaListaProdutos();
            dto.forEach(produto -> {
                Boolean retorno = produtoService.existsPorNome(produto.getNome());
                if (retorno.equals(false)) {
                    produtoService.salvaProdutos(converter.toEntity(produto));
                }
            });
            return produtoService.buscaTodosProdutos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar produtos no banco de dados");
        }
    }
}
