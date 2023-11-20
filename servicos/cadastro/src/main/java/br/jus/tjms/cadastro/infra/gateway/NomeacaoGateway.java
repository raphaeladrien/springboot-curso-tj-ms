package br.jus.tjms.cadastro.infra.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "NOMEACAO-SERVICE")
public interface NomeacaoGateway {
    @GetMapping("nomeacao")
    String getNumeroNomeacao(@RequestParam("cpf") String cpf);
}
