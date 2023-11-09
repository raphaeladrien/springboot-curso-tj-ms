package br.jus.tjms.exemplo.infra;

import br.jus.tjms.exemplo.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {

    boolean existsByNome(String nome);

}
