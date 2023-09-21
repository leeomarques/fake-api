package com.example.fakeapi.apiv1.controller;

import com.example.fakeapi.apiv1.dto.MissionarioDTO;
import com.example.fakeapi.business.service.MissionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missionarios")
@RequiredArgsConstructor
@Tag(name = "missionarios-api")
public class MissionarioController {

    private final MissionarioService missionarioService;

    @Operation(summary = "Salva novos Missionários", method = "POST")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missionário alvo com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao salvar o Missionário"),})
    @PostMapping("/")
    public ResponseEntity<MissionarioDTO> salvar(@RequestBody MissionarioDTO dto) {
        return ResponseEntity.ok(missionarioService.saveDTO(dto));
    }

    @Operation(summary = "Fazer update novos Missionários", method = "PUT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missionário atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Missionário"),})
    @PutMapping("/")
    public ResponseEntity<MissionarioDTO> atualizar(@RequestParam("id") String id, @RequestBody MissionarioDTO dto) {
        return ResponseEntity.ok(missionarioService.update(id, dto));
    }

    @Operation(summary = "Deleta Missionários", method = "DELETE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missionário deletado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao deletar o Missionário"),})
    @DeleteMapping("/")
    public ResponseEntity<Void> deletar(@RequestParam("id") String id) {
        missionarioService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os Missionários cadastrados", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missionário atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Missionário"),})
    @GetMapping("/")
    public ResponseEntity<List<MissionarioDTO>> buscarTodos() {
        return ResponseEntity.ok(missionarioService.findAll());
    }

    @Operation(summary = "Busca todos os Missionários por nome", method = "GET")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Missionário atualizado com sucesso"),
                           @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Missionário"),})
    @GetMapping("/{nome}")
    public ResponseEntity<MissionarioDTO> buscarPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(missionarioService.findByName(nome));
    }
}
