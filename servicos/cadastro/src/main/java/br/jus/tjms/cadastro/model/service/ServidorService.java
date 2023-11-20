package br.jus.tjms.cadastro.model.service;

import br.jus.tjms.cadastro.infra.gateway.NomeacaoGateway;
import br.jus.tjms.cadastro.infra.repository.ServidorRepository;
import br.jus.tjms.cadastro.model.entity.Servidor;
import org.springframework.stereotype.Service;

@Service
public class ServidorService {

    private final ServidorRepository servidorRepository;
    private final NomeacaoGateway nomeacaoGateway;

    public ServidorService(
        ServidorRepository servidorRepository,
        NomeacaoGateway nomeacaoGateway
    ) {
        this.servidorRepository = servidorRepository;
        this.nomeacaoGateway = nomeacaoGateway;
    }

    public Servidor cadastrar(Servidor servidor) {

        servidorRepository.save(servidor);
        return null;
    }
}
