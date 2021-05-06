package br.com.hot.escola.academico.dominio.aluno;

import br.com.hot.escola.sharedkernel.dominio.CPF;
import br.com.hot.escola.sharedkernel.evento.Evento;
import br.com.hot.escola.sharedkernel.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
