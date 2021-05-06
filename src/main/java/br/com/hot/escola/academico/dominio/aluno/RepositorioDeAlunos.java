package br.com.hot.escola.academico.dominio.aluno;

import br.com.hot.escola.sharedkernel.dominio.CPF;

import java.util.List;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();
}
