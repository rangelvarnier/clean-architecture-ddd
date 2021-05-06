package br.com.hot.escola.gameficacao.dominio;

import br.com.hot.escola.sharedkernel.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void adicionar(Selo selo);

    Selo buscarPorNome(String nome);

    List<Selo> buscarPorCpf(CPF cpf);
}
