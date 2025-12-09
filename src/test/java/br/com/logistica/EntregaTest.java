package br.com.logistica;

import br.com.logistica.exception.DadosInvalidosException;
import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EntregaTest {

    @Test
    void naoDeveCriarEntregaComEnderecoNulo() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega(null, 10, TipoFrete.PADRAO, "Destinatario"));
        assertEquals("Endereco nulo", ex.getMessage());
    }

    @Test
    void naoDeveCriarEntregaComEnderecoVazio() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega(" ", 10, TipoFrete.PADRAO, "Destinatario"));
        assertEquals("Endereco vazio", ex.getMessage());
    }

    @Test
    void naoDeveCriarEntregaComTipoFreteNulo() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega("Endereco", 10, null, "Destinatario"));
        assertEquals("Frete nulo", ex.getMessage());
    }

    @Test
    void naoDeveCriarEntregaComDestinatarioNulo() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega("Endereco", 10, TipoFrete.PADRAO, null));
        assertEquals("Destinatario nulo", ex.getMessage());
    }

    @Test
    void naoDeveCriarEntregaComDestinatarioVazio() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega("Endereco", 10, TipoFrete.PADRAO, "  "));
        assertEquals("Destinatario vazio", ex.getMessage());
    }

    @Test
    void naoDeveCriarEntregaComPesoInvalido() {
        var ex = assertThrows(DadosInvalidosException.class, () -> new Entrega("Endereco", 0, TipoFrete.PADRAO, "Destinatario"));
        assertEquals("Peso deve ser maior que zero", ex.getMessage());
    }
}
