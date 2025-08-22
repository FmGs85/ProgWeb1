package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@Tag(name="Categoria", description="API para gerenciamento das categorias do sistema")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todas as categorias do sistema")
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/listarPorId/{idCategoria}")
    @Operation(summary = "Listar categoria pelo id")
    public ResponseEntity<Categoria> listarPorId(@PathVariable("idCategoria") Integer idCategoria){
        Categoria categoria = categoriaService.listarCategoriaPorId(idCategoria);
        if (categoria == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categoria);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar nova categoria")
    public String criar(@RequestBody Categoria categoria){
        categoriaService.criarCategoria(categoria);
        return "Categoria criada com sucesso!";
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar uma categoria")
    public String atualizar(@RequestBody Categoria categoria){
        categoriaService.atualizarCategoria(categoria);
        return "Categoria atualizada com sucesso!";
    }

    @DeleteMapping("/apagar/{idCategoria}")
    @Operation(summary = "Apagar uma categoria")
    public String apagar(@PathVariable("idCategoria") Integer idCategoria){
        categoriaService.apagarCategoria(idCategoria);
        return "Categoria apagada com sucesso!";
    }
}
