package br.jus.tjms.alvara.servico.dto;

import java.time.Instant;
import java.util.UUID;

public record AlvaraDTO(UUID id, Instant data, String nome) {
}
