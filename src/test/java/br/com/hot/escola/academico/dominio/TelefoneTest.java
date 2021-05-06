package br.com.hot.escola.academico.dominio;

import br.com.hot.escola.academico.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void naoDeveriaCriarUmTelefoneComDDDInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("498", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("4", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "12345678"));
    }

    @Test
    void naoDeveriaCriarUmTelefoneComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("49", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("49", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("49", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("49", null));
    }

    @Test
    void deveriaCriarUmTelefoneValido() {
        assertDoesNotThrow(() -> new Telefone("49", "12345-1234"));
        assertDoesNotThrow(() -> new Telefone("49", "1234-1234"));
    }
}