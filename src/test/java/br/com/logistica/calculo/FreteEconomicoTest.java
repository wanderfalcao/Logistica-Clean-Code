package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FreteEconomicoTest {

    @Test
    void deveRetornarZeroParaPesoAbaixoDaIsencao() {
        FreteEconomico freteEconomico = new FreteEconomico();
        Entrega entrega = new Entrega("Endereco", 1.5, TipoFrete.ECONOMICO, "Destinatario");
        double valor = freteEconomico.calcular(entrega);
        assertEquals(0.0, valor, 0.01);
    }

    @Test
    void deveRetornarZeroParaPesoIgualAoLimiteDeIsencao() {
        FreteEconomico freteEconomico = new FreteEconomico();
        Entrega entrega = new Entrega("Endereco", 2.0, TipoFrete.ECONOMICO, "Destinatario");
        double valor = freteEconomico.calcular(entrega);
        assertEquals(0.0, valor, 0.01);
    }

    @Test
    void deveCalcularFreteParaPesoAcimaDaIsencao() {
        FreteEconomico freteEconomico = new FreteEconomico();
        Entrega entrega = new Entrega("Endereco", 10, TipoFrete.ECONOMICO, "Destinatario");
        double valor = freteEconomico.calcular(entrega);
        assertEquals(6.0, valor, 0.01);
    }

    @Test
    void deveRetornarZeroQuandoCalculoResultarNegativo() {
        FreteEconomico freteEconomico = new FreteEconomico();
        Entrega entrega = new Entrega("Endereco", 4, TipoFrete.ECONOMICO, "Destinatario");
        double valor = freteEconomico.calcular(entrega);
        assertEquals(0.0, valor, 0.01);
    }
}
