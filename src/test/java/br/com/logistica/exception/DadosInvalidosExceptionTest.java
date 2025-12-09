package br.com.logistica.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DadosInvalidosExceptionTest {

    @Test
    void testConstrutor() {
        String mensagem = "Mensagem de teste";
        DadosInvalidosException exception = new DadosInvalidosException(mensagem);
        assertEquals(mensagem, exception.getMessage());
    }
}
