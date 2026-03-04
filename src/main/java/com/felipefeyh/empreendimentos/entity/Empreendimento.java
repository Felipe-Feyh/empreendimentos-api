package com.felipefeyh.empreendimentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "empreendimentos")
public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nomeEmpreendimento;

    @Column(nullable = false)
    private String nomeEmpreendedor;

    @Column(nullable = false)
    private String municipio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Segmento segmento;

    @Column(nullable = false)
    private String emailContato;

    @Column(nullable = false)
    private Boolean ativo = true;

    public enum Segmento {
        TECNOLOGIA, COMERCIO, INDUSTRIA, SERVICOS, AGRONEGOCIO
    }
}