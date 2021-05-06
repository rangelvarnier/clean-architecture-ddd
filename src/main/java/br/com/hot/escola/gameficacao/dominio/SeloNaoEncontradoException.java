package br.com.hot.escola.gameficacao.dominio;

import static java.lang.String.format;

public class SeloNaoEncontradoException extends RuntimeException {
    public SeloNaoEncontradoException(String selo) {
        super(format("Selo %s não foi encontrado!", selo));
    }
}
