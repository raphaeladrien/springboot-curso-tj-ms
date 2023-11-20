package br.jus.tjms.nomeacao.model.dto;

import java.util.UUID;

public record ServidorDTO(
    UUID id,
    String nome,
    Integer matricula
) {
}
