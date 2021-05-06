package br.com.hot.escola.dominio.aluno;

import static java.lang.String.format;

public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(CPF cpf) {
        super(format("Aluno com CPF %s não encontrado", cpf.getNumero()));
    }
}
