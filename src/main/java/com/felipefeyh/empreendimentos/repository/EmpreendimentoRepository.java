package com.felipefeyh.empreendimentos.repository;

import com.felipefeyh.empreendimentos.entity.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, UUID> {
}