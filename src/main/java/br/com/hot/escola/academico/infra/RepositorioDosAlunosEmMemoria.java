package br.com.hot.escola.academico.infra;

import br.com.hot.escola.academico.dominio.aluno.Aluno;
import br.com.hot.escola.academico.dominio.aluno.AlunoNaoEncontradoException;
import br.com.hot.escola.academico.dominio.aluno.CPF;
import br.com.hot.escola.academico.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDosAlunosEmMemoria implements RepositorioDeAlunos {

    private final List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(aluno -> aluno.getCpf().getNumero().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
