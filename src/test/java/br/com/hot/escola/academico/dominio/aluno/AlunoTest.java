package br.com.hot.escola.academico.dominio.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new FabricaDeAluno()
                .comNomeCPFEmail("juca", "000.000.000-00", "juca@mail.com")
                .criar();
    }

    @Test
    void deveriaAdicionarTelefone() {
        assertDoesNotThrow(() -> aluno.adicionarTelefone("00", "0000-0000"));
    }

    @Test
    void naoDeveriaAdicionarTelefone() {
        assertThrows(LimiteMaximoTelefonesException.class, () -> {
            aluno.adicionarTelefone("00", "0000-0000");
            aluno.adicionarTelefone("00", "0000-0000");
            aluno.adicionarTelefone("00", "0000-0000");
        });
    }
}