package br.jus.tjms.alvara.controller;

import br.jus.tjms.alvara.servico.AlvaraServico;
import br.jus.tjms.alvara.servico.dto.AlvaraDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("alvara")
public class AlvaraController {

    private final AlvaraServico alvaraServico;

    public AlvaraController(AlvaraServico alvaraServico) {
        this.alvaraServico = alvaraServico;
    }

    @GetMapping
    public ResponseEntity<AlvaraDTO> alvara() {
        return ResponseEntity.ok(alvaraServico.getAlvara());
    }
}
