package br.com.logistica.servico;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import br.com.logistica.exception.DadosInvalidosException;
import br.com.logistica.formatacao.FormatadorEtiqueta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EtiquetaServiceTest {

    @Test
    void testGerarComConstrutorPadrao() {
        EtiquetaService etiquetaService = new EtiquetaService();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.PADRAO, "Destinatario");
        String etiqueta = etiquetaService.gerar(entrega);
        assertEquals("Destinatario: Destinatario\nEndereco: Endereco\nTipo: PADRAO\nValor Total: R$\u00A012,00", etiqueta);
    }

    @Test
    void testGerarComFormatadorCustomizado() {
        FormatadorEtiqueta formatador = (entrega, valor) -> "FORMATO CUSTOMIZADO";
        EtiquetaService etiquetaService = new EtiquetaService(formatador);
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.PADRAO, "Destinatario");
        String etiqueta = etiquetaService.gerar(entrega);
        assertEquals("FORMATO CUSTOMIZADO", etiqueta);
    }

    @Test
    void testGerarComEntregaNula() {
        EtiquetaService etiquetaService = new EtiquetaService();
        assertThrows(DadosInvalidosException.class, () -> {
            etiquetaService.gerar(null);
        });
    }
}
