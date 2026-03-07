package com.felipefeyh.empreendimentos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "empreendimentos")
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Nome do empreendimento é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String nomeEmpreendimento;

    @NotNull(message = "Nome do empreendedor é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String nomeEmpreendedor;

    @NotNull(message = "Município é obrigatório")
    @Size(min = 2, max = 50, message = "Município deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String municipio;

    @NotNull(message = "Segmento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Segmento segmento;

    @NotNull(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(nullable = false)
    private String emailContato;

    @Column(nullable = false)
    private Boolean ativo = true;

    public enum Segmento {
        TECNOLOGIA, COMERCIO, INDUSTRIA, SERVICOS, AGRONEGOCIO
    }
}