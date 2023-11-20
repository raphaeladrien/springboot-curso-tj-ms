package br.jus.tjms.nomeacao.infra.repository;

import br.jus.tjms.nomeacao.model.entity.NomeacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NomeacaoRepository extends JpaRepository<NomeacaoModel, UUID> {
}
