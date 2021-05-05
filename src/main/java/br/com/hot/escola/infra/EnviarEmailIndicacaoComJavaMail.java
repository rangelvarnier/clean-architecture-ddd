package br.com.hot.escola.infra;

import br.com.hot.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.hot.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        //Logica de envio de email com java mail
    }
}
