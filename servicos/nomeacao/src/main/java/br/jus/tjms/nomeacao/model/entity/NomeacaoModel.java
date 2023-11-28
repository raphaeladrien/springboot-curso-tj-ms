package br.jus.tjms.nomeacao.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String nome;

    @Enumerated(EnumType.STRING)
    private NomeacaoStatus nomeacaoStatus;

    private UUID externalUUID;

    public NomeacaoModel() {
        super();
    }

    public NomeacaoModel(
        String cargo,
        String provimento,
        Integer classificacao,
        Integer matricula,
        NomeacaoStatus nomeacaoStatus,
        String nome
    ) {
        this.cargo = cargo;
        this.provimento = provimento;
        this.classificacao = classificacao;
        this.matricula = matricula;
        this.nomeacaoStatus = nomeacaoStatus;
        this.nome = nome;
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

    public NomeacaoStatus getNomeacaoStatus() {
        return nomeacaoStatus;
    }
    public void setNomeacaoStatus(NomeacaoStatus nomeacaoStatus) {
        this.nomeacaoStatus = nomeacaoStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
