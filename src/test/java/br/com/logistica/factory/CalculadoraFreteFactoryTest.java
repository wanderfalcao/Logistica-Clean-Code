package br.com.logistica.factory;

import br.com.logistica.model.TipoFrete;
import br.com.logistica.calculo.CalculadoraFrete;
import br.com.logistica.calculo.FreteEconomico;
import br.com.logistica.calculo.FretePadrao;
import br.com.logistica.calculo.PromocaoReducaoPeso;
import br.com.logistica.exception.DadosInvalidosException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteFactoryTest {

    @Test
    void deveCriarCalculadoraFreteExpresso() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.EXPRESSO);
        assertInstanceOf(PromocaoReducaoPeso.class, calculadora);
    }

    @Test
    void deveCriarCalculadoraFretePadrao() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.PADRAO);
        assertInstanceOf(FretePadrao.class, calculadora);
    }

    @Test
    void deveCriarCalculadoraFreteEconomico() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.ECONOMICO);
        assertInstanceOf(FreteEconomico.class, calculadora);
    }

    @Test
    void naoDeveCriarComTipoNulo() {
        assertThrows(DadosInvalidosException.class, () -> CalculadoraFreteFactory.criar(null));
    }
}
