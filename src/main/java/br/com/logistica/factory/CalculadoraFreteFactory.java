package br.com.logistica.factory;

import br.com.logistica.model.TipoFrete;
import br.com.logistica.calculo.*;
import br.com.logistica.exception.DadosInvalidosException;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class CalculadoraFreteFactory {
    private static final Map<TipoFrete, Supplier<CalculadoraFrete>> registro = new EnumMap<>(TipoFrete.class);

    static {
        registro.put(TipoFrete.EXPRESSO, () -> new PromocaoReducaoPeso(new FreteExpresso()));
        registro.put(TipoFrete.PADRAO, FretePadrao::new);
        registro.put(TipoFrete.ECONOMICO, FreteEconomico::new);
    }

    private CalculadoraFreteFactory() {}

    public static CalculadoraFrete criar(TipoFrete tipo) {
        if (tipo == null) throw new DadosInvalidosException("Frete NULO");
        return registro.get(tipo).get();
    }
}
