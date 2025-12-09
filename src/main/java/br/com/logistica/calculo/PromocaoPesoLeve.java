package br.com.logistica.calculo; 
import br.com.logistica.model.Entrega;
public class PromocaoPesoLeve extends CalculadoraFreteDecorator { 
    private static final double LIMITE_PESO = 10.0; 
    private static final double REDUCAO = 1.0; 
    public PromocaoPesoLeve(CalculadoraFrete calcFrete) { super(calcFrete); } 
    @Override 
    public double calcular(Entrega entrega) { 
        if (entrega.peso() > LIMITE_PESO) { 
            Entrega virt = new Entrega(entrega.endereco(), entrega.peso() - REDUCAO, entrega.tipoFrete(), entrega.destinatario());
            return calculadoraEnvolvida.calcular(virt);
        } 
        return calculadoraEnvolvida.calcular(entrega); 
    } 
} 
