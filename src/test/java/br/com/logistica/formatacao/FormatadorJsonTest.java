package br.com.logistica.formatacao;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatadorJsonTest {

    @Test
    void testFormatar() {
        FormatadorJSON formatador = new FormatadorJSON();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.PADRAO, "Destinatario");
        String json = formatador.formatar(entrega, 12.0);
        assertEquals("{ \"destinatario\": \"Destinatario\", \"valor\": 12.00 }", json);
    }
}
