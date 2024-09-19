package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Projeto;
import com.ong.ong_ong.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/projetos")
@Tag(name = "Projetos", description = "API para operações relacionadas aos projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    @Operation(summary = "Lista todos os projetos")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        return ResponseEntity.ok(projetoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um projeto pelo ID")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        return projetoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria um novo projeto")
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        return ResponseEntity.ok(projetoService.save(projeto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um projeto existente pelo ID")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        return projetoService.findById(id)
                .map(existingProjeto -> {
                    projeto.setId(existingProjeto.getId());
                    return ResponseEntity.ok(projetoService.save(projeto));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um projeto pelo ID")
    public ResponseEntity<?> deleteProjeto(@PathVariable Long id) {
        return projetoService.findById(id)
                .map(projeto -> {
                    projetoService.deleteById(projeto.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
