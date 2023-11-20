package br.jus.tjms.cadastro.app;

import br.jus.tjms.cadastro.model.dto.ServidorDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("servidor")
public class ServidorController {

    @GetMapping
    public ResponseEntity<ServidorDTO> obterPorMatricula(
        @RequestParam Integer matricula
    ) {
        List<ServidorDTO> servidores = List.of(
            new ServidorDTO(UUID.randomUUID(), "José Maria", 1),
            new ServidorDTO(UUID.randomUUID(), "Maria José", 2),
            new ServidorDTO(UUID.randomUUID(), "João da Silva", 3),
            new ServidorDTO(UUID.randomUUID(), "Nuno Ferreira", 4)
        );

        final ServidorDTO servidor = servidores
            .stream()
            .filter(it -> it.matricula() == matricula)
            .findFirst()
            .get();

        return ResponseEntity.ok(servidor);
    }
}
