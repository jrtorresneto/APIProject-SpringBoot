package com.kidopilabs.com.br.teste.controller.data.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PacienteRequest {

    @NotBlank(message = "Nome do paciente deve ser informado")
    private String nome;

    @NotNull(message = "A idade do paciente deve ser informado")
    private String idade;

    @NotNull(message = "O sexo do paciente deve ser informado")
    private String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
