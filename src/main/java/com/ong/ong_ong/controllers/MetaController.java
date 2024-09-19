package com.ong.ong_ong.controllers;

import com.ong.ong_ong.database.model.Meta;
import com.ong.ong_ong.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
@Tag(name = "Metas", description = "API para operações relacionadas às metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    @Operation(summary = "Lista todas as metas")
    public ResponseEntity<List<Meta>> getAllMetas() {
        return ResponseEntity.ok(metaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma meta pelo ID")
    public ResponseEntity<Meta> getMetaById(@PathVariable Long id) {
        return metaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria uma nova meta")
    public ResponseEntity<Meta> createMeta(@RequestBody Meta meta) {
        return ResponseEntity.ok(metaService.save(meta));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma meta existente pelo ID")
    public ResponseEntity<Meta> updateMeta(@PathVariable Long id, @RequestBody Meta meta) {
        return metaService.findById(id)
                .map(existingMeta -> {
                    meta.setId(existingMeta.getId());
                    return ResponseEntity.ok(metaService.save(meta));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma meta pelo ID")
    public ResponseEntity<?> deleteMeta(@PathVariable Long id) {
        return metaService.findById(id)
                .map(meta -> {
                    metaService.deleteById(meta.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
