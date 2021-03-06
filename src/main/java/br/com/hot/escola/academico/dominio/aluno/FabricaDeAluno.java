package br.com.hot.escola.academico.dominio.aluno;

import br.com.hot.escola.sharedkernel.dominio.CPF;

public class FabricaDeAluno {
    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String telefone) {
        this.aluno.adicionarTelefone(ddd, telefone);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }

}
