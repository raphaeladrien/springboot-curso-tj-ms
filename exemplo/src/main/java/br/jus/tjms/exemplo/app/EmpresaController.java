package br.jus.tjms.exemplo.app;

import br.jus.tjms.exemplo.model.entity.Empresa;
import br.jus.tjms.exemplo.model.service.EmpresaServico;
import jakarta.validation.Valid;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    private final EmpresaServico empresaServico;

    public EmpresaController(EmpresaServico empresaServico) {
        this.empresaServico = empresaServico;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponse> cadastrarEmpresa(
        @RequestBody @Valid Empresa empresa
    ) {
        Empresa retEmpresa = empresaServico.gravar(empresa);
        return ResponseEntity.ok(EmpresaResponse.build(retEmpresa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> obterPorId(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(EmpresaResponse.build(empresaServico.obterPorId(id)));
    }

    private static class EmpresaResponse extends RepresentationModel<EmpresaResponse> {
        private final String nome;
        private final String endereco;
        private final Integer numeroFuncionarios;

        private EmpresaResponse(String nome, String endereco, Integer numeroFuncionario) {
            this.nome = nome;
            this.endereco = endereco;
            this.numeroFuncionarios = numeroFuncionario;
        }

        public static EmpresaResponse build(Empresa empresa) {
            final EmpresaResponse response = new EmpresaResponse(
                empresa.getNome(),
                empresa.getEndereco(),
                empresa.getNumeroFuncionario()
            );

            response.add(linkTo(methodOn(EmpresaController.class).obterPorId(empresa.getId())).withSelfRel());
            response.add(linkTo(methodOn(ProcessoController.class).obterProcessos()).withRel("processos"));

            return response;
        }

        public String getNome() {
            return nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public Integer getNumeroFuncionarios() {
            return numeroFuncionarios;
        }
    }
}
