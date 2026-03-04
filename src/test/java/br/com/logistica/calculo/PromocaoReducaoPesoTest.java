package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PromocaoReducaoPesoTest {

    @Test
    @DisplayName("Deve aplicar a promoção para entregas com peso acima do limite")
    void deveAplicarPromocao() {
        CalculadoraFrete fretePadrao = new FretePadrao();
        PromocaoReducaoPeso promocao = new PromocaoReducaoPeso(fretePadrao);
        Entrega entrega = new Entrega("Endereco", 11, TipoFrete.PADRAO, "Destinatario");
        double valor = promocao.calcular(entrega);
        assertEquals(12.0, valor, 0.01);
    }

    @Test
    @DisplayName("NÃO deve aplicar a promoção para entregas com peso abaixo do limite")
    void naoDeveAplicarPromocao() {
        CalculadoraFrete fretePadrao = new FretePadrao();
        PromocaoReducaoPeso promocao = new PromocaoReducaoPeso(fretePadrao);
        Entrega entrega = new Entrega("Endereco", 9, TipoFrete.PADRAO, "Destinatario");
        double valor = promocao.calcular(entrega);
        assertEquals(10.8, valor, 0.01);
    }
}
