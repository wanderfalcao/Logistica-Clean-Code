package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FretePadraoTest {

    @Test
    @DisplayName("Deve calcular o frete padrão corretamente para um peso de 10kg")
    void deveCalcularFretePadrao() {
        FretePadrao fretePadrao = new FretePadrao();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.PADRAO, "Destinatario");
        double valor = fretePadrao.calcular(entrega);
        assertEquals(12.0, valor, 0.01);
    }
}
