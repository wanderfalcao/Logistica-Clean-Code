package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FreteExpressoTest {

    @Test
    @DisplayName("Deve calcular o frete expresso corretamente para um peso de 10kg")
    void deveCalcularFreteExpresso() {
        System.out.println("--- Testando Cálculo de Frete Expresso ---");
        FreteExpresso freteExpresso = new FreteExpresso();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.EXPRESSO, "Destinatario");
        double valor = freteExpresso.calcular(entrega);
        System.out.printf("Peso: %.1fkg, Valor Calculado: R$%.2f%n", entrega.peso(), valor);
        assertEquals(25.0, valor, 0.01);
    }
}
