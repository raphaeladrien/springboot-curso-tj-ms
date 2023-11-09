package br.jus.tjms.exemplo.app;

import br.jus.tjms.exemplo.model.entity.Empresa;
import br.jus.tjms.exemplo.model.service.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    private final EmpresaServico empresaServico;

    public EmpresaController(EmpresaServico empresaServico) {
        this.empresaServico = empresaServico;
    }

    @PostMapping
    public String cadastrarEmpresa(@RequestBody Empresa empresa) {
        Empresa retEmpresa = empresaServico.gravar(empresa);
        return retEmpresa.getNome();
    }
}
