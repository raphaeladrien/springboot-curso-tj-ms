package br.jus.tjms.nomeacao.model.param;

import java.time.LocalDateTime;

public record NomeacaoParam(
    String cargo,
    String provimento,
    Integer classificacao,
    Integer matricula) {
}
