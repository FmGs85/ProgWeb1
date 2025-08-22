package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patrocinador")
@Tag(name="Patrocinador", description="API para gerenciamento dos patrocinadores do sistema")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os patrocinadores do sistema")
    public ResponseEntity<List<Patrocinador>> listar(){
        return ResponseEntity.ok(patrocinadorService.listarPatrocinadores());
    }

    @GetMapping("/listarPorId/{idPatrocinador}")
    @Operation(summary = "Listar patrocinador pelo id")
    public ResponseEntity<Patrocinador> listarPorId(@PathVariable("idPatrocinador") Integer idPatrocinador){
        Patrocinador patrocinador = patrocinadorService.listarPatrocinadorPorId(idPatrocinador);
        if (patrocinador == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patrocinador);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar novo patrocinador")
    public String criar(@RequestBody Patrocinador patrocinador){
        patrocinadorService.criarPatrocinador(patrocinador);
        return "Patrocinador criado com sucesso!";
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar patrocinador")
    public String atualizar(@RequestBody Patrocinador patrocinador){
        patrocinadorService.atualizarPatrocinador(patrocinador);
        return "Patrocinador atualizado com sucesso!";
    }

    @DeleteMapping("/apagar/{idPatrocinador}")
    @Operation(summary = "Apagar patrocinador")
    public String apagar(@PathVariable("idPatrocinador") Integer idPatrocinador){
        patrocinadorService.apagarPatrocinador(idPatrocinador);
        return "Patrocinador apagado com sucesso!";
    }
}
