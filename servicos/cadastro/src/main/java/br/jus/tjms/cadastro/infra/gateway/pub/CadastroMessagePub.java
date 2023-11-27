package br.jus.tjms.cadastro.infra.gateway.pub;

import br.jus.tjms.cadastro.model.dto.ServidorDTO;
import br.jus.tjms.cadastro.model.entity.Servidor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CadastroMessagePub {

    private final KafkaTemplate kafkaTemplate;

    public CadastroMessagePub(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem() {
        final ServidorDTO servidorDTO = new ServidorDTO(UUID.randomUUID(),
            "raphael",
            1234);

        kafkaTemplate.send(
            "tjms-cadastro",
            UUID.randomUUID().toString(),
            servidorDTO
        );
    }
}
