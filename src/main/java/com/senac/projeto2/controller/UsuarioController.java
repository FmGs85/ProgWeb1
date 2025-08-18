package com.senac.projeto2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description="api para gerenciamento dos usuários do sistema")
public class UsuarioController {
    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public String listar(){
        return "Listando com sucesso";
    }
    @GetMapping("/listarPoridUsuario/{idUsuario}")
    @Operation (summary = "Listar usuarios do sistema pelo id do usuário")
    public String listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return "Listando um usuario por id com sucesso"+ idUsuario + " com sucesso";
    }

    @PostMapping("/criar")
    public String criar(){
        return "Usuário criado com sucesso!";
    }
    @PutMapping("/atualizar")
    public String atualizar(){
        return "Usuário atualizado com sucesso";
    }
    @DeleteMapping("/apagar")
    public String apagar(){
        return "Usuário apagado com sucesso";
    }
}
