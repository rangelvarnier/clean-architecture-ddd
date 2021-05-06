package br.com.hot.escola.gameficacao.dominio;

import br.com.hot.escola.academico.dominio.aluno.CPF;

public class Selo {
    private CPF cpf;
    private String nome;

    public Selo(CPF cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
