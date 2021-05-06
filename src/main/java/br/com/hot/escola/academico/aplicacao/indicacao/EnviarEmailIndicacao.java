package br.com.hot.escola.academico.aplicacao.indicacao;

import br.com.hot.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
