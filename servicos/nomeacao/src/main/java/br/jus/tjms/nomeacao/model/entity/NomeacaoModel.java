package br.jus.tjms.nomeacao.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;
@Entity
public class NomeacaoModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String cargo;
    private String provimento;
    private Integer classificacao;
    private Integer matricula;

    private UUID externalUUID;

    public NomeacaoModel() {
        super();
    }

    public NomeacaoModel(String cargo, String provimento, Integer classificacao, Integer matricula) {
        this.cargo = cargo;
        this.provimento = provimento;
        this.classificacao = classificacao;
        this.matricula = matricula;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getProvimento() {
        return provimento;
    }

    public void setProvimento(String provimento) {
        this.provimento = provimento;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public UUID getExternalUUID() {
        return externalUUID;
    }

    public void setExternalUUID(UUID externalUUID) {
        this.externalUUID = externalUUID;
    }
}
