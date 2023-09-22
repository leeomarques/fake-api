package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.HistoricoDTO;
import com.example.fakeapi.business.service.HistoricoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
@RequiredArgsConstructor
@Tag(name = "API - Histórico")
public class HistoricoController {

    private final HistoricoService historicoService;

    @Operation(summary = "Salva novos dados do Histórico", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Histórico salvo com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar os dados do Histórico"),})
    @PostMapping("/")
    public ResponseEntity<HistoricoDTO> salvar(@RequestBody HistoricoDTO dto) {
        return ResponseEntity.ok(historicoService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos dados do Histórico", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Histórico atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados do Histórico"),})
    @PutMapping("/")
    public ResponseEntity<HistoricoDTO> atualizar(@RequestParam("id") Long id, @RequestBody HistoricoDTO dto) {
        return ResponseEntity.ok(historicoService.update(id, dto));
    }

    @Operation(summary = "Deleta dados do Histórico", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Histórico deletado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar os dados do Histórico"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        historicoService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os dados do Histórico cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Histórico atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados do Histórico"),})
    @GetMapping("/")
    public ResponseEntity<List<HistoricoDTO>> buscarTodos() {
        return ResponseEntity.ok(historicoService.findAll());
    }

    @Operation(summary = "Busca todos os dados do Histórico por Id", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Histórico atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados do Histórico"),})
    @GetMapping("/{id}")
    public ResponseEntity<HistoricoDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(historicoService.findById(id));
    }
}
