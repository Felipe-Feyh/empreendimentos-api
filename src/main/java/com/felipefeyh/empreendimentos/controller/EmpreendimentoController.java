package com.felipefeyh.empreendimentos.controller;

import com.felipefeyh.empreendimentos.entity.Empreendimento;
import com.felipefeyh.empreendimentos.service.EmpreendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/empreendimentos")
@RequiredArgsConstructor
public class EmpreendimentoController {

    private final EmpreendimentoService service;

    @PostMapping
    public ResponseEntity<Empreendimento> criar(@Valid @RequestBody Empreendimento empreendimento) {
        Empreendimento criado = service.criar(empreendimento);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<Empreendimento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empreendimento> buscar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empreendimento> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Empreendimento dadosAtualizacao) {
        return ResponseEntity.ok(service.atualizar(id, dadosAtualizacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
