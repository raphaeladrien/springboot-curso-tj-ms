package br.jus.tjms.nomeacao.infra.gateway.consumer;

import br.jus.tjms.nomeacao.model.dto.ServidorDTO;
import br.jus.tjms.nomeacao.model.service.NomeacaoServico;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CadastroListener {

    private final ObjectMapper objectMapper;
    private final NomeacaoServico nomeacaoServico;

    public CadastroListener(ObjectMapper objectMapper, NomeacaoServico nomeacaoServico) {
        this.objectMapper = objectMapper;
        this.nomeacaoServico = nomeacaoServico;
    }

    @KafkaListener(topics = "tjms-cadastro", groupId = "tjms")
    public void consume(ConsumerRecord<?, ?> message) throws IOException {
        final ServidorDTO servidorDTO = objectMapper.readValue(message.value().toString(),
            ServidorDTO.class);


        System.out.println("Mensagem recebida: " + servidorDTO.toString());
    }
}
