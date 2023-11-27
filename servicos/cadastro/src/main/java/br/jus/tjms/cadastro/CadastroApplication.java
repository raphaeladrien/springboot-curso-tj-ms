package br.jus.tjms.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients
@EnableKafka
public class CadastroApplication {
    public static void main(String[] args) {
        SpringApplication.run(CadastroApplication.class, args);
    }
}
