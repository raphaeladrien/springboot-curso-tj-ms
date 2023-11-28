package br.jus.tjms.logexemplo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("empresa")
public class EmpresaControler {

    private static Logger logger = LoggerFactory.getLogger(EmpresaControler.class);

    private final RestTemplate restTemplate;

    public EmpresaControler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cadastro")
    public ResponseEntity cadastro() {
        logger.info("cadastrar cliente");
        String response = restTemplate.getForObject("http://localhost:8889/empresa/obter", String.class);
        return ResponseEntity.ok("cadastrado");
    }

    @GetMapping("/obter")
    public ResponseEntity obter() {
        logger.info("obter client");
        return ResponseEntity.ok("cadastrado");
    }

}
