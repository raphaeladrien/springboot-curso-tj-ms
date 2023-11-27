package br.jus.tjms.cadastro.model.dto;

import java.util.UUID;

public class ServidorDTO{
    private UUID id;
    private String nome;
    private Integer matricula;

    public ServidorDTO() {
        super();
    }

    public ServidorDTO(UUID id, String nome, Integer matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
