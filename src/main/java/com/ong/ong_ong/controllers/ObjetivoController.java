package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Objetivo;
import com.ong.ong_ong.services.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/objetivos")
@Tag(name = "Objetivos", description = "API para operações relacionadas aos objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @GetMapping
    @Operation(summary = "Lista todos os objetivos")
    public ResponseEntity<List<Objetivo>> getAllObjetivos() {
        return ResponseEntity.ok(objetivoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um objetivo pelo ID")
    public ResponseEntity<Objetivo> getObjetivoById(@PathVariable Long id) {
        return objetivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria um novo objetivo")
    public ResponseEntity<Objetivo> createObjetivo(@RequestBody Objetivo objetivo) {
        return ResponseEntity.ok(objetivoService.save(objetivo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um objetivo existente pelo ID")
    public ResponseEntity<Objetivo> updateObjetivo(@PathVariable Long id, @RequestBody Objetivo objetivo) {
        return objetivoService.findById(id)
                .map(existingObjetivo -> {
                    objetivo.setId(existingObjetivo.getId());
                    return ResponseEntity.ok(objetivoService.save(objetivo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um objetivo pelo ID")
    public ResponseEntity<?> deleteObjetivo(@PathVariable Long id) {
        return objetivoService.findById(id)
                .map(objetivo -> {
                    objetivoService.deleteById(objetivo.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
