package br.jus.tjms.exemplo.model.service;

import br.jus.tjms.exemplo.infra.EmpresaRepository;
import br.jus.tjms.exemplo.model.entity.Empresa;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class EmpresaServico {

    private final EmpresaRepository empresaRepository;

    public EmpresaServico(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Empresa gravar(Empresa empresa) {

        if (empresaRepository.existsByNome(empresa.getNome())) {
            throw new RuntimeException("Já existe uma empresa com este nome");
        }

        return empresaRepository.save(empresa);
    }
}
