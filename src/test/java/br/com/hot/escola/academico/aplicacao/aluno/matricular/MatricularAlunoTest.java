package br.com.hot.escola.academico.aplicacao.aluno.matricular;

import br.com.hot.escola.academico.dominio.eventodedominio.PublicadorDeEventos;
import br.com.hot.escola.academico.dominio.aluno.Aluno;
import br.com.hot.escola.sharedkernel.dominio.CPF;
import br.com.hot.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.hot.escola.academico.infra.RepositorioDosAlunosEmMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    private MatricularAluno useCasematricularAluno;
    private RepositorioDosAlunosEmMemoria repositorio;

    @BeforeEach
    void setUp() {

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());

        repositorio = new RepositorioDosAlunosEmMemoria();
        useCasematricularAluno = new MatricularAluno(repositorio, publicador);
    }

    @Test
    void alunoDeveriaSerPersistido() {
        String cpf = "123.456.789-00";
        String nome = "juca";
        String email = "juca@mail.com";

        MatricularAlunoDto alunoDto = new MatricularAlunoDto(nome, email, cpf);
        useCasematricularAluno.executa(alunoDto);

        Aluno alunoPersistido = repositorio.buscarPorCPF(new CPF(cpf));

        assertEquals(cpf, alunoPersistido.getCpf().getNumero());
        assertEquals(nome, alunoPersistido.getNome());
        assertEquals(email, alunoPersistido.getEmail());
    }
}