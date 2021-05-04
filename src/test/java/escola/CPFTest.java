package escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void naoDeveriaCriarUmCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF("00.00.00-0"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("0000.0000.0000-000"));
    }

    @Test
    void deveriaCriarUmCPFValido() {
        assertDoesNotThrow(() -> new CPF("000.000.000-00"));
    }
}