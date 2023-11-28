package br.jus.tjms.nomeacao.app;

import br.jus.tjms.nomeacao.model.context.ContextHolder;
import br.jus.tjms.nomeacao.model.param.NomeacaoParam;
import br.jus.tjms.nomeacao.model.service.NomeacaoServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nomeacao")
public class NomeacaoController {

    private final NomeacaoServico nomeacaoServico;
    private final ContextHolder contextHolder;

    private static final Logger logger = LoggerFactory
        .getLogger(NomeacaoController.class);

    private NomeacaoController(
        NomeacaoServico nomeacaoServico,
        ContextHolder contextHolder
    ) {
        this.nomeacaoServico = nomeacaoServico;
        this.contextHolder = contextHolder;
    }

    @PutMapping
    public ResponseEntity nomearFuncionario(@RequestBody NomeacaoParam nomeacaoParam) {
        logger.info("pedido para registrar o funcionario requestId " + contextHolder.getRequestId());
        return ResponseEntity.ok(nomeacaoServico.gravar(nomeacaoParam));
    }
}
