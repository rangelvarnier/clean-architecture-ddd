package br.com.hot.escola.gameficacao.infra;

import br.com.hot.escola.sharedkernel.dominio.CPF;
import br.com.hot.escola.gameficacao.dominio.RepositorioDeSelos;
import br.com.hot.escola.gameficacao.dominio.Selo;
import br.com.hot.escola.gameficacao.dominio.SeloNaoEncontradoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private final Set<Selo> selos = new HashSet<>();

    @Override
    public void adicionar(Selo selo) {
        selos.add(selo);
    }

    @Override
    public Selo buscarPorNome(String nome) {
        return selos.stream()
                .filter(selo -> selo.getNome().equals(nome))
                .findFirst()
                .orElseThrow(() -> new SeloNaoEncontradoException(nome));
    }

    @Override
    public List<Selo> buscarPorCpf(CPF cpf) {
        return selos.stream()
                .filter(selo -> selo.getCpf().getNumero().equals(cpf.getNumero()))
                .toList();
    }
}
