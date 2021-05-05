package br.com.hot.escola;

import br.com.hot.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.hot.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.hot.escola.infra.RepositorioDosAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        var nome = "Juca Bala";
        var cpf = "123.456.789-00";
        var email = "juca.bala@email.com";

        MatricularAlunoDto alunoDto = new MatricularAlunoDto(nome, email, cpf);

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDosAlunosEmMemoria());
        matricularAluno.executa(alunoDto);
    }
}
