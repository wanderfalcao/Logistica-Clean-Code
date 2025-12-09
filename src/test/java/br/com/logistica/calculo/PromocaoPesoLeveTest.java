package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PromocaoPesoLeveTest {

    @Test
    @DisplayName("Deve aplicar a promoção para entregas com peso acima do limite")
    void deveAplicarPromocao() {
        System.out.println("--- Testando Promoção de Peso Leve (COM APLICAÇÃO) ---");
        CalculadoraFrete fretePadrao = new FretePadrao();
        PromocaoPesoLeve promocao = new PromocaoPesoLeve(fretePadrao);
        Entrega entrega = new Entrega("Endereco", 11, TipoFrete.PADRAO, "Destinatario");
        double valor = promocao.calcular(entrega);
        System.out.printf("Cenário: Peso (%.1fkg) > Limite. O cálculo deve considerar o peso reduzido.%n", entrega.peso());
        System.out.printf("Valor Calculado: R$%.2f%n", valor);
        assertEquals(12.0, valor, 0.01);
    }

    @Test
    @DisplayName("NÃO deve aplicar a promoção para entregas com peso abaixo do limite")
    void naoDeveAplicarPromocao() {
        System.out.println("--- Testando Promoção de Peso Leve (SEM APLICAÇÃO) ---");
        CalculadoraFrete fretePadrao = new FretePadrao();
        PromocaoPesoLeve promocao = new PromocaoPesoLeve(fretePadrao);
        Entrega entrega = new Entrega("Endereco", 9, TipoFrete.PADRAO, "Destinatario");
        double valor = promocao.calcular(entrega);
        System.out.printf("Cenário: Peso (%.1fkg) <= Limite. O cálculo deve usar o peso original.%n", entrega.peso());
        System.out.printf("Valor Calculado: R$%.2f%n", valor);
        assertEquals(10.8, valor, 0.01);
    }
}
