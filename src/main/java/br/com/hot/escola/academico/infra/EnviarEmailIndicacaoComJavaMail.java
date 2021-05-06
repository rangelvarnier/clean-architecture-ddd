package br.com.hot.escola.academico.infra;

import br.com.hot.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.hot.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        //Logica de envio de email com java mail
    }
}
