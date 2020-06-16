package com.kidopilabs.com.br.teste.controller.data.response;

public class PacienteResponse {

    private String id;
    private String nome;
    private String idade;
    private String sexo;

    private PacienteResponse(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.idade = builder.idade;
        this.sexo = builder.sexo;
    }

    //Builder Class
    public static class Builder {

        private String id;
        private String nome;
        private String idade;
        private String sexo;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder idade(String idade) {
            this.idade = idade;
            return this;
        }

        public Builder sexo(String sexo) {
            this.sexo = sexo;
            return this;
        }

        public PacienteResponse build() {
            return new PacienteResponse(this);
        }

    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

}
