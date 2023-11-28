package br.jus.tjms.nomeacao.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    private final String bootstrapServers;

    public KafkaTopicConfig(
        @Value("${spring.kafka.bootstrap-servers}")
        String bootstrapServers
    ) {
        this.bootstrapServers = bootstrapServers;
    }

    @Bean
    public NewTopic nomeacao() {
        return new NewTopic(
            Topicos.NOMEACAO,
            1,
            (short) 1
        );
    }
}
