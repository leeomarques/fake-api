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

    @Operation(summary = "Salva novas Missões", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar a Missão"),})
    @PostMapping("/")
    public ResponseEntity<MissaoDTO> salvar(@RequestBody MissaoDTO dto) {
        return ResponseEntity.ok(missaoService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novas Missões", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Missão"),})
    @PutMapping("/")
    public ResponseEntity<MissaoDTO> atualizar(@RequestParam("id") Long id, @RequestBody MissaoDTO dto) {
        return ResponseEntity.ok(missaoService.update(id, dto));
    }

    @Operation(summary = "Deleta Missões", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão deletado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar a Missão"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        missaoService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os Missões cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missão atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Missão"),})
    @GetMapping("/")
    public ResponseEntity<List<MissaoDTO>> buscarTodos() {
        return ResponseEntity.ok(missaoService.findAll());
    }

}
