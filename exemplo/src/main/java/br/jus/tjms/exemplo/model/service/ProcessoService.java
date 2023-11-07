package br.jus.tjms.exemplo.model.service;

import br.jus.tjms.exemplo.model.entity.Processo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessoService {
    public List<Processo> obter() {
        return List.of(new Processo("raphael", 12));
    }
}
