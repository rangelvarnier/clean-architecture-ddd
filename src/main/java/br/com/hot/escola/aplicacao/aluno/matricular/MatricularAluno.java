package br.com.hot.escola.aplicacao.aluno.matricular;

import br.com.hot.escola.dominio.aluno.Aluno;
import br.com.hot.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    //COMMAND
    public void executa(MatricularAlunoDto alunoDto) {
        Aluno alunoNovo = alunoDto.criarAluno();
        repositorio.matricular(alunoNovo);
    }
}
