package br.com.hot.escola.academico.dominio.aluno;

public class LimiteMaximoTelefonesException extends RuntimeException {
    public LimiteMaximoTelefonesException() {
        super("Número máximo de telefones já foi atingido!");
    }
}
