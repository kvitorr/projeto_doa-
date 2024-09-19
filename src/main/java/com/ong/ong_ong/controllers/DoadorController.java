package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Doador;
import com.ong.ong_ong.services.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/doadores")
@Tag(name = "Doadores", description = "API para operações relacionadas aos doadores")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @GetMapping
    @Operation(summary = "Lista todos os doadores")
    public ResponseEntity<List<Doador>> getAllDoadores() {
        return ResponseEntity.ok(doadorService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um doador pelo ID")
    public ResponseEntity<Doador> getDoadorById(@PathVariable Long id) {
        return doadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria um novo doador")
    public ResponseEntity<Doador> createDoador(@RequestBody Doador doador) {
        return ResponseEntity.ok(doadorService.save(doador));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um doador existente pelo ID")
    public ResponseEntity<Doador> updateDoador(@PathVariable Long id, @RequestBody Doador doador) {
        return doadorService.findById(id)
                .map(existingDoador -> {
                    doador.setId(existingDoador.getId());
                    return ResponseEntity.ok(doadorService.save(doador));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um doador pelo ID")
    public ResponseEntity<?> deleteDoador(@PathVariable Long id) {
        return doadorService.findById(id)
                .map(doador -> {
                    doadorService.deleteById(doador.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
