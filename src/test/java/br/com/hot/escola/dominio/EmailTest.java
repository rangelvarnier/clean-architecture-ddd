package br.com.hot.escola.dominio;

import br.com.hot.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> new Email(null));
        assertThrows(IllegalArgumentException.class, ()-> new Email("emailInvalido"));
        assertThrows(IllegalArgumentException.class, ()-> new Email(""));
    }

    @Test
    void deveriaCriarUmEmailValido() {
        assertDoesNotThrow(()-> new Email("emailvalido@email.com"));
    }
}