package br.jus.tjms.funcionario.controller;

import br.jus.tjms.funcionario.gateway.AlvaraGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    private final AlvaraGateway alvaraGateway;

    public FuncionarioController(AlvaraGateway alvaraGateway) {
        this.alvaraGateway = alvaraGateway;
    }

    @GetMapping
    public String obterFuncionario() {
        return "funcionario com " + alvaraGateway.getAlvara();
    }
}
