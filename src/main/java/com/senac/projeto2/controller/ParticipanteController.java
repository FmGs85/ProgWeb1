package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.service.ParticipanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/participante")
@Tag(name="Participante", description="API para gerenciamento dos participantes do sistema")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os participantes do sistema")
    public ResponseEntity<List<Participante>> listar(){
        return ResponseEntity.ok(participanteService.listarParticipantes());
    }

    @GetMapping("/listarPorId/{idParticipante}")
    @Operation(summary = "Listar participante pelo id")
    public ResponseEntity<Participante> listarPorId(@PathVariable("idParticipante") Integer idParticipante){
        Participante participante = participanteService.listarParticipantePorId(idParticipante);
        if (participante == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(participante);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar novo participante")
    public String criar(@RequestBody Participante participante){
        participanteService.criarParticipante(participante);
        return "Participante criado com sucesso!";
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar participante")
    public String atualizar(@RequestBody Participante participante){
        participanteService.atualizarParticipante(participante);
        return "Participante atualizado com sucesso!";
    }

    @DeleteMapping("/apagar/{idParticipante}")
    @Operation(summary = "Apagar participante")
    public String apagar(@PathVariable("idParticipante") Integer idParticipante){
        participanteService.apagarParticipante(idParticipante);
        return "Participante apagado com sucesso!";
    }
}
