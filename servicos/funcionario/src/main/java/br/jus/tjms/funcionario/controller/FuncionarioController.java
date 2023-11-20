package br.jus.tjms.funcionario.controller;

import br.jus.tjms.funcionario.gateway.AlvaraGateway;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> obterFunctionario(
        @PathVariable("id") Integer id
    ) {
        List<Funcionario> funcionarios = List.of(
            new Funcionario(1, "Raphael"),
            new Funcionario(2, "Rafaela")
        );

        Funcionario funcionario = funcionarios.stream()
            .filter(it -> it.id == id)
            .findFirst()
            .get();

        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(
        @RequestBody Funcionario funcionario
    ) {
        // Imagina que existe um codigo lindo para salvar este funcionario
        return ResponseEntity.ok(funcionario);
    }

    private record Funcionario(Integer id, String nome){}

}
