package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.ComunhaoDeBensDTO;
import com.example.fakeapi.business.service.ComunhaoDeBensService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunhaoDeBens")
@RequiredArgsConstructor
@Tag(name = "API - Comunhão de Bens")
public class ComunhaoDeBensController {

    private final ComunhaoDeBensService comunhaoDeBensService;

    @Operation(summary = "Salva novos Registros da CB", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens salva com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar a Comunhão de Bens"),})
    @PostMapping("/")
    public ResponseEntity<ComunhaoDeBensDTO> salvar(@RequestBody ComunhaoDeBensDTO dto) {
        return ResponseEntity.ok(comunhaoDeBensService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos Registros da CB", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Comunhão de Bens"),})
    @PutMapping("/")
    public ResponseEntity<ComunhaoDeBensDTO> atualizar(@RequestParam("id") Long id, @RequestBody ComunhaoDeBensDTO dto) {
        return ResponseEntity.ok(comunhaoDeBensService.update(id, dto));
    }

    @Operation(summary = "Deleta Registros da CB", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens deletada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar a Comunhão de Bens"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        comunhaoDeBensService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os Registros da CB cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Comunhão de Bens atualizada com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar a Comunhão de Bens"),})
    @GetMapping("/")
    public ResponseEntity<List<ComunhaoDeBensDTO>> buscarTodos() {
        return ResponseEntity.ok(comunhaoDeBensService.findAll());
    }

}
