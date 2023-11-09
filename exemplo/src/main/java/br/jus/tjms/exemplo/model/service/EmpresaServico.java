package br.jus.tjms.exemplo.model.service;

import br.jus.tjms.exemplo.infra.EmpresaRepository;
import br.jus.tjms.exemplo.infra.exception.RegisterAlreadyExists;
import br.jus.tjms.exemplo.model.entity.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServico {

    private final EmpresaRepository empresaRepository;

    public EmpresaServico(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Empresa gravar(Empresa empresa) {
        if (empresaRepository.existsByNome(empresa.getNome())) {
            throw new RegisterAlreadyExists("Já existe uma empresa com este nome");
        }

        return empresaRepository.save(empresa);
    }
}
