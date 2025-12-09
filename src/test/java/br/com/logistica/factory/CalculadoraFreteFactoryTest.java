package br.com.logistica.factory;

import br.com.logistica.model.TipoFrete;
import br.com.logistica.calculo.CalculadoraFrete;
import br.com.logistica.calculo.FreteEconomico;
import br.com.logistica.calculo.FretePadrao;
import br.com.logistica.calculo.PromocaoPesoLeve;
import br.com.logistica.exception.DadosInvalidosException;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteFactoryTest {

    private static void execute() {
        CalculadoraFreteFactory.criar(TipoFrete.EXPRESSO);
    }

    @Test
    void testCriarFreteExpresso() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.EXPRESSO);
        assertInstanceOf(PromocaoPesoLeve.class, calculadora);
    }

    @Test
    void testCriarFretePadrao() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.PADRAO);
        assertInstanceOf(FretePadrao.class, calculadora);
    }

    @Test
    void testCriarFreteEconomico() {
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(TipoFrete.ECONOMICO);
        assertInstanceOf(FreteEconomico.class, calculadora);
    }

    @Test
    void testCriarComTipoNulo() {
        assertThrows(DadosInvalidosException.class, () -> {
            CalculadoraFreteFactory.criar(null);
        });
    }

    @Test
    void testCriarComEstrategiaInexistente() throws Exception {
        Field registroField = CalculadoraFreteFactory.class.getDeclaredField("registro");
        registroField.setAccessible(true);
        Map<TipoFrete, Supplier<CalculadoraFrete>> registro = (Map<TipoFrete, Supplier<CalculadoraFrete>>) registroField.get(null);

        // Salva o valor original para restaurar depois
        Supplier<CalculadoraFrete> original = registro.remove(TipoFrete.EXPRESSO);

        try {
            var ex = assertThrows(DadosInvalidosException.class, CalculadoraFreteFactoryTest::execute);
            assertTrue(ex.getMessage().contains("Estrategia nao existe"));
        } finally {
            // Restaura o valor original
            registro.put(TipoFrete.EXPRESSO, original);
        }
    }
}
