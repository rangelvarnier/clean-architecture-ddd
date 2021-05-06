package br.com.hot.escola.academico.dominio.aluno;

import br.com.hot.escola.academico.dominio.eventodedominio.Evento;
import br.com.hot.escola.sharedkernel.dominio.CPF;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;

    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
