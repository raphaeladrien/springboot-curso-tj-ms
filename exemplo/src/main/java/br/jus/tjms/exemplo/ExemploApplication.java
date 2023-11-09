package br.jus.tjms.exemplo;

import br.jus.tjms.exemplo.model.service.ProcessoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploApplication.class, args);
	}

}
