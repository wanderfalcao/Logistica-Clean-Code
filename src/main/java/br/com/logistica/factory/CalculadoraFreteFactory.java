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
        registro.put(TipoFrete.EXPRESSO, () -> new PromocaoPesoLeve(new FreteExpresso())); 
        registro.put(TipoFrete.PADRAO, FretePadrao::new); 
        registro.put(TipoFrete.ECONOMICO, FreteEconomico::new); 
    } 
    public static CalculadoraFrete criar(TipoFrete tipo) { 
        if (tipo == null) throw new DadosInvalidosException("Frete NULO"); 
        Supplier<CalculadoraFrete> criador = registro.get(tipo); 
        if (criador == null) throw new DadosInvalidosException("Estrategia nao existe: " + tipo); 
        return criador.get(); 
    } 
} 
