package br.jus.tjms.cadastro.model.dto;

import java.util.UUID;

public record ServidorDTO(
    UUID id,
    String nome,
    Integer matricula
) {
}
