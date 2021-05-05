package br.com.hot.escola.aplicacao.aluno.matricular;

import br.com.hot.escola.dominio.aluno.Aluno;
import br.com.hot.escola.dominio.aluno.FabricaDeAluno;

public class MatricularAlunoDto {

    private final String nome;
    private final String email;
    private final String cpf;

    public MatricularAlunoDto(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Aluno criarAluno() {
        return new FabricaDeAluno().comNomeCPFEmail(this.nome, this.cpf, this.email).criar();
    }
}
