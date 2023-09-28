package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.ReciclagemDTO;
import com.example.fakeapi.business.service.ReciclagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reciclagem")
@RequiredArgsConstructor
@Tag(name = "API - Reciclagem")
public class ReciclagemController {

    private final ReciclagemService reciclagemService;

    @Operation(summary = "Salva novas reciclagens", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar a Reciclagem"),})
    @PostMapping("/")
    public ResponseEntity<ReciclagemDTO> salvar(@RequestBody ReciclagemDTO dto) {
        return ResponseEntity.ok(reciclagemService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novas Reciclagens", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Reciclagem"),})
    @PutMapping("/")
    public ResponseEntity<ReciclagemDTO> atualizar(@RequestParam("id") Long id, @RequestBody ReciclagemDTO dto) {
        return ResponseEntity.ok(reciclagemService.update(id, dto));
    }

    @Operation(summary = "Deleta Reciclagens", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem deletada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar a Reciclagem"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        reciclagemService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos as Reciclagens cadastradas", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Reciclagem"),})
    @GetMapping("/")
    public ResponseEntity<List<ReciclagemDTO>> buscarTodos() {
        return ResponseEntity.ok(reciclagemService.findAll());
    }

}
