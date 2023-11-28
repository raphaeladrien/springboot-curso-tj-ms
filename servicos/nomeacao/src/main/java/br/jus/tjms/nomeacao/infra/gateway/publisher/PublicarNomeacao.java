package br.jus.tjms.nomeacao.infra.gateway.publisher;

import br.jus.tjms.nomeacao.config.Topicos;
import br.jus.tjms.nomeacao.model.dto.NomeacaoDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublicarNomeacao {

    private final KafkaTemplate kafkaTemplate;

    public PublicarNomeacao(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(NomeacaoDTO nomeacaoDTO, String messageId) {
        kafkaTemplate.send(
            Topicos.NOMEACAO,
            messageId,
            nomeacaoDTO
        );
    }
}
