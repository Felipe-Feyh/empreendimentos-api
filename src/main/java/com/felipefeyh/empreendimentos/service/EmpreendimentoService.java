package com.felipefeyh.empreendimentos.service;

import com.felipefeyh.empreendimentos.entity.Empreendimento;
import com.felipefeyh.empreendimentos.exception.ResourceNotFoundException;
import com.felipefeyh.empreendimentos.repository.EmpreendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmpreendimentoService {
    private final EmpreendimentoRepository repository;

    public Empreendimento criar(Empreendimento empreendimento) {
        return repository.save(empreendimento);
    }

    public List<Empreendimento> listar() {
        return repository.findAll();
    }

    public Empreendimento buscarPorId(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empreendimento não encontrado: " + id));
    }

    public Empreendimento atualizar(UUID id, Empreendimento dadosAtualizacao) {
        Empreendimento existente = buscarPorId(id);
        existente.setNomeEmpreendimento(dadosAtualizacao.getNomeEmpreendimento());
        existente.setNomeEmpreendedor(dadosAtualizacao.getNomeEmpreendedor());
        existente.setMunicipio(dadosAtualizacao.getMunicipio());
        existente.setSegmento(dadosAtualizacao.getSegmento());
        existente.setEmailContato(dadosAtualizacao.getEmailContato());
        existente.setAtivo(dadosAtualizacao.getAtivo());
        return repository.save(existente);
    }

    public void deletar(UUID id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
