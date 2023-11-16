package br.jus.tjms.alvara.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("alvara")
public class AlvaraController {

    @GetMapping
    public String alvara() {
        throw new RuntimeException("an error");
        // return "Alvara " + Math.abs(new Random().nextInt());
    }
}
