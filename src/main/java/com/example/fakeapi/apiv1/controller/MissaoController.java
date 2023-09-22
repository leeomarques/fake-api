package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.MissaoDTO;
import com.example.fakeapi.business.service.MissaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
@RequiredArgsConstructor
@Tag(name = "API - Missão")
public class MissaoController {

    private final MissaoService missaoService;

    @Operation(summary = "Salva novos dados da  Missão", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar os dados da  Missão"),})
    @PostMapping("/")
    public ResponseEntity<MissaoDTO> salvar(@RequestBody MissaoDTO dto) {
        return ResponseEntity.ok(missaoService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos dados da  Missão", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da  Missão"),})
    @PutMapping("/")
    public ResponseEntity<MissaoDTO> atualizar(@RequestParam("id") Long id, @RequestBody MissaoDTO dto) {
        return ResponseEntity.ok(missaoService.update(id, dto));
    }

    @Operation(summary = "Deleta dados da  Missão", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar os dados da  Missão"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        missaoService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os dados da  Missão cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da  Missão"),})
    @GetMapping("/")
    public ResponseEntity<List<MissaoDTO>> buscarTodos() {
        return ResponseEntity.ok(missaoService.findAll());
    }

    @Operation(summary = "Busca todos os dados da  Missão por Id", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da  Missão"),})
    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(missaoService.findById(id));
    }
}
