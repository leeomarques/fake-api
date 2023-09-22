package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.ComunhaoBensDTO;
import com.example.fakeapi.business.service.ComunhaoBensService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunhaobens")
@RequiredArgsConstructor
@Tag(name = "API - Comunhão de Bens")
public class ComunhaoBensController {

    private final ComunhaoBensService comunhaoBensService;

    @Operation(summary = "Salva novos dados da Comunhão de Bens", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar os dados da Comunhão de Bens"),})
    @PostMapping("/")
    public ResponseEntity<ComunhaoBensDTO> salvar(@RequestBody ComunhaoBensDTO dto) {
        return ResponseEntity.ok(comunhaoBensService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos dados da Comunhão de Bens", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Comunhão de Bens"),})
    @PutMapping("/")
    public ResponseEntity<ComunhaoBensDTO> atualizar(@RequestParam("id") Long id, @RequestBody ComunhaoBensDTO dto) {
        return ResponseEntity.ok(comunhaoBensService.update(id, dto));
    }

    @Operation(summary = "Deleta dados da Comunhão de Bens", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens deletada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar os dados da Comunhão de Bens"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        comunhaoBensService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os dados da Comunhão de Bens cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Comunhão de Bens"),})
    @GetMapping("/")
    public ResponseEntity<List<ComunhaoBensDTO>> buscarTodos() {
        return ResponseEntity.ok(comunhaoBensService.findAll());
    }

    @Operation(summary = "Busca todos os dados da Comunhão de Bens por Id", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da Comunhão de Bens"),})
    @GetMapping("/{id}")
    public ResponseEntity<ComunhaoBensDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(comunhaoBensService.findById(id));
    }
}
