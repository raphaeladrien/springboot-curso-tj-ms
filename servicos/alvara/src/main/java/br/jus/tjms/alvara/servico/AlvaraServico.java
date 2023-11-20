package br.jus.tjms.alvara.servico;

import br.jus.tjms.alvara.gateway.FuncionarioGateway;
import br.jus.tjms.alvara.gateway.dto.FuncionarioDTO;
import br.jus.tjms.alvara.servico.dto.AlvaraDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AlvaraServico {

    private final FuncionarioGateway funcionarioGateway;

    public AlvaraServico(FuncionarioGateway funcionarioGateway) {
        this.funcionarioGateway = funcionarioGateway;
    }

    public AlvaraDTO getAlvara() {
        FuncionarioDTO funcionarioDTO = funcionarioGateway.enviarFuncionario(
            new FuncionarioDTO(10, "Maria João")
        );
        return new AlvaraDTO(
            UUID.randomUUID(),
            Instant.now(),
            funcionarioDTO.nome()
        );
    }
}
