package br.com.hot.escola.gameficacao.aplicacao;

import br.com.hot.escola.gameficacao.dominio.RepositorioDeSelos;
import br.com.hot.escola.gameficacao.dominio.Selo;
import br.com.hot.escola.sharedkernel.dominio.CPF;
import br.com.hot.escola.sharedkernel.evento.Evento;
import br.com.hot.escola.sharedkernel.evento.Ouvinte;

import static br.com.hot.escola.sharedkernel.evento.TipoDeEvento.ALUNO_MATRICULADO;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpf = (CPF) evento.informacoes().get("cpf");
        Selo selo = new Selo(cpf, "Novato");
        repositorioDeSelos.adicionar(selo);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return ALUNO_MATRICULADO.equals(evento.tipo());
    }
}
