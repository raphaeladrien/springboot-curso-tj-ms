package br.jus.tjms.exemplo.app;

import br.jus.tjms.exemplo.model.entity.Processo;
import br.jus.tjms.exemplo.model.service.ProcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("processo")
public class ProcessoController {

    private final ProcessoService processoService;
    public ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }
    @GetMapping
    public ResponseEntity<List<Processo>> obterProcessos() {
        return ResponseEntity.ok(processoService.obter());
    }

    @GetMapping("/param")
    public String processos(@RequestParam("nome") String nome) {
        return nome;
    }
}
