package br.com.hot.escola.aplicacao.indicacao;

import br.com.hot.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
