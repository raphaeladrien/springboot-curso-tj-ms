package br.jus.tjms.nomeacao.model.service;

import br.jus.tjms.nomeacao.infra.gateway.CadastroGateway;
import br.jus.tjms.nomeacao.infra.repository.NomeacaoRepository;
import br.jus.tjms.nomeacao.model.dto.ServidorDTO;
import br.jus.tjms.nomeacao.model.entity.NomeacaoModel;
import br.jus.tjms.nomeacao.model.param.NomeacaoParam;
import org.springframework.stereotype.Service;

@Service
public class NomeacaoServico {

    private final NomeacaoRepository nomeacaoRepository;
    private final CadastroGateway cadastroGateway;

    public NomeacaoServico(NomeacaoRepository nomeacaoRepository, CadastroGateway cadastroGateway) {
        this.nomeacaoRepository = nomeacaoRepository;
        this.cadastroGateway = cadastroGateway;
    }

    public NomeacaoModel gravar(NomeacaoParam nomeacaoParam) {
        final Integer matricula = nomeacaoParam.matricula();
        final NomeacaoModel nomeacaoModel = new NomeacaoModel(
            nomeacaoParam.cargo(),
            nomeacaoParam.provimento(),
            nomeacaoParam.classificacao(),
            matricula
        );

        final ServidorDTO servidorDTO = cadastroGateway.obterPorMatricula();
        nomeacaoModel.setExternalUUID(servidorDTO.id());

        return nomeacaoRepository.save(nomeacaoModel);
    }
}
