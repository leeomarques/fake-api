package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.MinisterioDTO;
import com.example.fakeapi.business.service.MinisterioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ministerio")
@RequiredArgsConstructor
@Tag(name = "API - Ministérios")
public class MinisterioController {

    private final MinisterioService ministerioService;

    @Operation(summary = "Salva novos Ministérios", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ministério salvo com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar o Ministério"),})
    @PostMapping("/")
    public ResponseEntity<MinisterioDTO> salvar(@RequestBody MinisterioDTO dto) {
        return ResponseEntity.ok(ministerioService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos Ministérios", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ministério atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Ministério"),})
    @PutMapping("/")
    public ResponseEntity<MinisterioDTO> atualizar(@RequestParam("id") Long id, @RequestBody MinisterioDTO dto) {
        return ResponseEntity.ok(ministerioService.update(id, dto));
    }

    @Operation(summary = "Deleta Ministérios", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ministério deletado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar o Ministério"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        ministerioService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os Ministérios cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ministério atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Ministério"),})
    @GetMapping("/")
    public ResponseEntity<List<MinisterioDTO>> buscarTodos() {
        return ResponseEntity.ok(ministerioService.findAll());
    }

}
