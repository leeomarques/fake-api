//package com.example.fakeapi.apiv1.controller;
//
//import com.example.fakeapi.apiv1.dto.ProductsDTO;
//import com.example.fakeapi.business.service.FakeApiService;
//import com.example.fakeapi.business.service.ProdutoService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/produtos")
//@RequiredArgsConstructor
//@Tag(name = "fake-api")
//public class FakeApiController {
//
//    private final FakeApiService service;
//    private final ProdutoService produtoService;
//
//    @Operation(summary = "Busca produtos da API e Salvar", method = "POST")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),})
//    @PostMapping("/api")
//    public ResponseEntity<List<ProductsDTO>> buscaProdutos() {
//        return ResponseEntity.ok(service.buscaProdutos());
//    }
//
//    @Operation(summary = "Salva novos produtos", method = "POST")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Produto alvo com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao salvar o produto"),})
//    @PostMapping("/")
//    public ResponseEntity<ProductsDTO> salvaProdutos(@RequestBody ProductsDTO dto) {
//        return ResponseEntity.ok(produtoService.salvaProdutoDTO(dto));
//    }
//
//    @Operation(summary = "Fazer update novos produtos", method = "PUT")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),})
//    @PutMapping("/")
//    public ResponseEntity<ProductsDTO> updateProdutos(@RequestParam("id") String id, @RequestBody ProductsDTO dto) {
//        return ResponseEntity.ok(produtoService.updateProduto(id, dto));
//    }
//
//    @Operation(summary = "Deleta produtos", method = "DELETE")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao deletar o produto"),})
//    @DeleteMapping("/")
//    public ResponseEntity<Void> deletaProdutos(@RequestParam("id") String id) {
//        produtoService.deletaProduto(id);
//        return ResponseEntity.accepted().build();
//    }
//
//    @Operation(summary = "Busca todos os produtos cadastrados", method = "GET")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),})
//    @GetMapping("/")
//    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos() {
//        return ResponseEntity.ok(produtoService.buscaTodosProdutos());
//    }
//
//    @Operation(summary = "Busca todos os produtos por nome", method = "GET")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
//                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),})
//    @GetMapping("/{nome}")
//    public ResponseEntity<ProductsDTO> buscaProdutoPorNome(@PathVariable("nome") String nome) {
//        return ResponseEntity.ok(produtoService.buscaProdutoPorNome(nome));
//    }
//
//
//}
