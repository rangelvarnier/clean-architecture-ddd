package br.com.hot.escola.academico.aplicacao.aluno.matricular;

import br.com.hot.escola.academico.dominio.eventodedominio.PublicadorDeEventos;
import br.com.hot.escola.academico.dominio.aluno.Aluno;
import br.com.hot.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.hot.escola.academico.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    //COMMAND
    public void executa(MatricularAlunoDto alunoDto) {
        Aluno alunoNovo = alunoDto.criarAluno();
        repositorio.matricular(alunoNovo);

        AlunoMatriculado eventoAlunoMatriculado = new AlunoMatriculado(alunoNovo.getCpf());
        publicador.publicar(eventoAlunoMatriculado);

    }
}
