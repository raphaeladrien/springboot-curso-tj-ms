package br.jus.tjms.cadastro.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public NewTopic topic() {
        return new NewTopic(
            "tjms-cadastro",
            1,
            (short) 1
        );
    }
}
