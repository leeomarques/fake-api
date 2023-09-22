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
@RequestMapping("/reciclagens")
@RequiredArgsConstructor
@Tag(name = "reciclagens-api")
public class ReciclagemController {

    private final ReciclagemService reciclagemService;

    @Operation(summary = "Salva novos dados da Reciclagem", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar os dados da Reciclagem"),})
    @PostMapping("/")
    public ResponseEntity<ReciclagemDTO> salvar(@RequestBody ReciclagemDTO dto) {
            return ResponseEntity.ok(reciclagemService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos dados da Reciclagem", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Reciclagem"),})
    @PutMapping("/")
    public ResponseEntity<ReciclagemDTO> atualizar(@RequestParam("id") Long id, @RequestBody ReciclagemDTO dto) {
        return ResponseEntity.ok(reciclagemService.update(id, dto));
    }

    @Operation(summary = "Deleta dados da Reciclagem", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem deletada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar os dados da Reciclagem"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        reciclagemService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os dados da Reciclagem cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Reciclagem"),})
    @GetMapping("/")
    public ResponseEntity<List<ReciclagemDTO>> buscarTodos() {
        return ResponseEntity.ok(reciclagemService.findAll());
    }

    @Operation(summary = "Busca todos os dados da Reciclagem por Id", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reciclagem atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Reciclagem"),})
    @GetMapping("/{id}")
    public ResponseEntity<ReciclagemDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reciclagemService.findById(id));
    }
}
