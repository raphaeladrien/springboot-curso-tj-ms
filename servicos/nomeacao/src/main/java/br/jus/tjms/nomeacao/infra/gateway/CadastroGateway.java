package br.jus.tjms.nomeacao.infra.gateway;

import br.jus.tjms.nomeacao.model.dto.ServidorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CADASTRO-SERVICE")
public interface CadastroGateway {
    @GetMapping
    ServidorDTO obterPorMatricula();
}
