package br.jus.tjms.nomeacao.app;

import br.jus.tjms.nomeacao.model.param.NomeacaoParam;
import br.jus.tjms.nomeacao.model.service.NomeacaoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nomeacao")
public class NomeacaoController {

    private final NomeacaoServico nomeacaoServico;

    private NomeacaoController(NomeacaoServico nomeacaoServico) {
        this.nomeacaoServico = nomeacaoServico;
    }

    @PutMapping
    public ResponseEntity nomearFuncionario(@RequestBody NomeacaoParam nomeacaoParam) {
        return ResponseEntity.ok(nomeacaoServico.gravar(nomeacaoParam));
    }
}
