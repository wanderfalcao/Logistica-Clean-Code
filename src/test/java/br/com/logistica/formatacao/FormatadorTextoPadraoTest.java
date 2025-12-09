package br.com.logistica.formatacao;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatadorTextoPadraoTest {

    @Test
    void testFormatar() {
        FormatadorTextoPadrao formatador = new FormatadorTextoPadrao();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.PADRAO, "Destinatario");
        String texto = formatador.formatar(entrega, 12.0);
        String expected = "Destinatario: Destinatario\nEndereco: Endereco\nTipo: PADRAO\nValor Total: R$\u00A012,00";
        assertEquals(expected, texto);
    }
}
