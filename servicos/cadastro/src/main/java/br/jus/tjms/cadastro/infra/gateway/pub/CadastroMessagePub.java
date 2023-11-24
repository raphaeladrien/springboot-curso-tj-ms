package br.jus.tjms.cadastro.infra.gateway.pub;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CadastroMessagePub {

    private final KafkaTemplate kafkaTemplate;

    public CadastroMessagePub(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem() {
        kafkaTemplate.send("tjms-cadastro", "cadastrado");
    }
}
