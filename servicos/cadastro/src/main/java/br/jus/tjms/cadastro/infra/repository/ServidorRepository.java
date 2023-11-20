package br.jus.tjms.cadastro.infra.repository;

import br.jus.tjms.cadastro.model.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, UUID> {
}
