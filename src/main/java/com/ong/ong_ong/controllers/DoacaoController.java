package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Doacao;
import com.ong.ong_ong.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/doacoes")
@Tag(name = "Doacoes", description = "API para operações relacionadas às doações")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping
    @Operation(summary = "Lista todas as doações")
    public ResponseEntity<List<Doacao>> getAllDoacoes() {
        return ResponseEntity.ok(doacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma doação pelo ID")
    public ResponseEntity<Doacao> getDoacaoById(@PathVariable Long id) {
        return doacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria uma nova doação")
    public ResponseEntity<Doacao> createDoacao(@RequestBody Doacao doacao) {
        return ResponseEntity.ok(doacaoService.save(doacao));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma doação existente pelo ID")
    public ResponseEntity<Doacao> updateDoacao(@PathVariable Long id, @RequestBody Doacao doacao) {
        return doacaoService.findById(id)
                .map(existingDoacao -> {
                    doacao.setId(existingDoacao.getId());
                    return ResponseEntity.ok(doacaoService.save(doacao));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma doação pelo ID")
    public ResponseEntity<?> deleteDoacao(@PathVariable Long id) {
        return doacaoService.findById(id)
                .map(doacao -> {
                    doacaoService.deleteById(doacao.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
