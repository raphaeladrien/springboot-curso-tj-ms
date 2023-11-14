package br.jus.tjms.exemplo.model.entity;


import br.jus.tjms.exemplo.model.entity.validacoes.ClienteGroupSequenceProvider;
import br.jus.tjms.exemplo.model.entity.validacoes.CpfGroup;
import br.jus.tjms.exemplo.model.entity.validacoes.CpnjGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.UUID;

@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private String nome;
    @Size(min = 3, max = 200, message = "O valor tem que ser entre 3 e 200")
    private String endereco;

    @NotNull
    @NotBlank @NotEmpty
    private String telefone;

    @Column(name = "numero_funcionario")
    private Integer numeroFuncionario;

    public Empresa() {
        super();
    }

    public UUID getId() {
        return id;
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
