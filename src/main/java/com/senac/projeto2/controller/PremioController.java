package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.service.PremioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/premio")
@Tag(name="Premio", description="API para gerenciamento dos premios do sistema")
public class PremioController {

    private final PremioService premioService;

    public PremioController(PremioService premioService) {
        this.premioService = premioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os premios do sistema")
    public ResponseEntity<List<Premio>> listar(){
        return ResponseEntity.ok(premioService.listarPremios());
    }

    @GetMapping("/listarPorId/{idPremio}")
    @Operation(summary = "Listar premio pelo id")
    public ResponseEntity<Premio> listarPorId(@PathVariable("idPremio") Integer idPremio){
        Premio premio = premioService.listarPremioPorId(idPremio);
        if (premio == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(premio);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar novo premio")
    public String criar(@RequestBody Premio premio){
        premioService.criarPremio(premio);
        return "Premio criado com sucesso!";
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar premio")
    public String atualizar(@RequestBody Premio premio){
        premioService.atualizarPremio(premio);
        return "Premio atualizado com sucesso!";
    }

    @DeleteMapping("/apagar/{idPremio}")
    @Operation(summary = "Apagar premio")
    public String apagar(@PathVariable("idPremio") Integer idPremio){
        premioService.apagarPremio(idPremio);
        return "Premio apagado com sucesso!";
    }
}
