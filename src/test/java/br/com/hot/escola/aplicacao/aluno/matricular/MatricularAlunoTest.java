package br.com.hot.escola.aplicacao.aluno.matricular;

import br.com.hot.escola.dominio.aluno.Aluno;
import br.com.hot.escola.dominio.aluno.CPF;
import br.com.hot.escola.infra.RepositorioDosAlunosEmMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    private MatricularAluno useCasematricularAluno;
    private RepositorioDosAlunosEmMemoria repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new RepositorioDosAlunosEmMemoria();
        useCasematricularAluno = new MatricularAluno(repositorio);
    }

    @Test
    void alunoDeveriaSerPersistido() {
        String cpf = "123.456.789-00";
        String nome = "juca";
        String email = "juca@mail.com";
        
        MatricularAlunoDto alunoDto = new MatricularAlunoDto(nome, email, cpf);
        useCasematricularAluno.executa(alunoDto);

        Aluno alunoPersistido = repositorio.buscarPorCPF(new CPF(cpf));

        assertEquals(cpf, alunoPersistido.getCpf());
        assertEquals(nome, alunoPersistido.getNome());
        assertEquals(email, alunoPersistido.getEmail());
    }
}