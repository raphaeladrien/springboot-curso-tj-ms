package br.jus.tjms.nomeacao.model.service;

import br.jus.tjms.nomeacao.infra.gateway.CadastroGateway;
import br.jus.tjms.nomeacao.infra.gateway.publisher.PublicarNomeacao;
import br.jus.tjms.nomeacao.infra.repository.NomeacaoRepository;
import br.jus.tjms.nomeacao.model.context.ContextHolder;
import br.jus.tjms.nomeacao.model.dto.NomeacaoDTO;
import br.jus.tjms.nomeacao.model.dto.ServidorDTO;
import br.jus.tjms.nomeacao.model.entity.NomeacaoModel;
import br.jus.tjms.nomeacao.model.entity.NomeacaoStatus;
import br.jus.tjms.nomeacao.model.param.NomeacaoParam;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class NomeacaoServico {

    private final NomeacaoRepository nomeacaoRepository;
    private final PublicarNomeacao publicarNomeacao;
    private final CadastroGateway cadastroGateway;

    private final ContextHolder contextHolder;

    public NomeacaoServico(
        NomeacaoRepository nomeacaoRepository,
        PublicarNomeacao publicarNomeacao,
        CadastroGateway cadastroGateway,
        ContextHolder contextHolder
    ) {
        this.nomeacaoRepository = nomeacaoRepository;
        this.publicarNomeacao = publicarNomeacao;
        this.contextHolder = contextHolder;
        this.cadastroGateway = cadastroGateway;
    }

    @Transactional
    public NomeacaoModel gravar(NomeacaoParam nomeacaoParam) {
        NomeacaoModel nomeacao = null;
        try {
            final Integer matricula = nomeacaoParam.matricula();
            final String cargo = nomeacaoParam.cargo();
            final String nome = nomeacaoParam.nome();

            // cadastroGateway.obterPorMatricula(matricula);

            nomeacao = nomeacaoRepository.save(
                new NomeacaoModel(
                    nomeacaoParam.cargo(),
                    nomeacaoParam.provimento(),
                    nomeacaoParam.classificacao(),
                    matricula,
                    NomeacaoStatus.AGUARDANDO_CADASTRO,
                    nomeacaoParam.nome()
            ));

            publicarNomeacao.enviarMensagem(
                new NomeacaoDTO(matricula, cargo, nome),
                contextHolder.getRequestId()
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nomeacao;
    }
}
