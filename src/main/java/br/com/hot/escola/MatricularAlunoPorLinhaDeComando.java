package br.com.hot.escola;

import br.com.hot.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.hot.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.hot.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.hot.escola.academico.infra.RepositorioDosAlunosEmMemoria;
import br.com.hot.escola.gameficacao.aplicacao.GeraSeloAlunoNovato;
import br.com.hot.escola.gameficacao.infra.RepositorioDeSelosEmMemoria;
import br.com.hot.escola.sharedkernel.dominio.CPF;
import br.com.hot.escola.sharedkernel.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        var nome = "Juca Bala";
        var cpf = "123.456.789-00";
        var email = "juca.bala@email.com";

        MatricularAlunoDto alunoDto = new MatricularAlunoDto(nome, email, cpf);

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        RepositorioDeSelosEmMemoria repositorioDeSelos = new RepositorioDeSelosEmMemoria();
        publicador.adicionar(new GeraSeloAlunoNovato(repositorioDeSelos));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDosAlunosEmMemoria(), publicador);
        matricularAluno.executa(alunoDto);

        System.out.println(repositorioDeSelos.buscarPorCpf(new CPF(cpf)));
    }
}
