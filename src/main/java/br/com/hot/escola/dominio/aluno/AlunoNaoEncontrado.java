package br.com.hot.escola.dominio.aluno;

import static java.lang.String.format;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super(format("Aluno com CPF %s não encontrado", cpf.getNumero()));
    }
}
