package br.com.hot.escola.academico.dominio.aluno;

import br.com.hot.escola.sharedkernel.evento.Evento;
import br.com.hot.escola.sharedkernel.evento.Ouvinte;

import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

/**
 * Ouvinte do Evento AlunoMatriculado
 */
public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(Evento evento) {
        String momento = evento.momento().format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm"));
        System.out.println(format("Aluno com CPF %s matriculado em %s", ((AlunoMatriculado) evento).getCpfDoAluno(), momento));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
