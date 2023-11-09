package br.jus.tjms.exemplo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String endereco;
    private String telefone;

    @Column(name = "numero_funcionario")
    private Integer numeroFuncionario;

    public Empresa() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(Integer numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }
}
