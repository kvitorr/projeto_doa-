package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Despesa;
import com.ong.ong_ong.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/despesas")
@Tag(name = "Despesas", description = "API para operações relacionadas às despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    @Operation(summary = "Lista todas as despesas")
    public ResponseEntity<List<Despesa>> getAllDespesas() {
        return ResponseEntity.ok(despesaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma despesa pelo ID")
    public ResponseEntity<Despesa> getDespesaById(@PathVariable Long id) {
        return despesaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria uma nova despesa")
    public ResponseEntity<Despesa> createDespesa(@RequestBody Despesa despesa) {
        return ResponseEntity.ok(despesaService.save(despesa));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma despesa existente pelo ID")
    public ResponseEntity<Despesa> updateDespesa(@PathVariable Long id, @RequestBody Despesa despesa) {
        return despesaService.findById(id)
                .map(existingDespesa -> {
                    despesa.setId(existingDespesa.getId());
                    return ResponseEntity.ok(despesaService.save(despesa));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma despesa pelo ID")
    public ResponseEntity<?> deleteDespesa(@PathVariable Long id) {
        return despesaService.findById(id)
                .map(despesa -> {
                    despesaService.deleteById(despesa.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
