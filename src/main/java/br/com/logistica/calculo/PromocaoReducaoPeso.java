package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;

public class PromocaoReducaoPeso extends CalculadoraFreteDecorator {
    private static final double LIMITE_PESO = 10.0;
    private static final double REDUCAO = 1.0;

    public PromocaoReducaoPeso(CalculadoraFrete calcFrete) {
        super(calcFrete);
    }

    @Override
    public double calcular(Entrega entrega) {
        if (entrega.peso() > LIMITE_PESO) {
            return calculadoraEnvolvida.calcular(entrega.comPeso(entrega.peso() - REDUCAO));
        }
        return super.calcular(entrega);
    }
}
