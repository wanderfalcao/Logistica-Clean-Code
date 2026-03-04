package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;

public abstract class CalculadoraFreteDecorator implements CalculadoraFrete {
    protected final CalculadoraFrete calculadoraEnvolvida;

    public CalculadoraFreteDecorator(CalculadoraFrete calculadoraEnvolvida) {
        this.calculadoraEnvolvida = calculadoraEnvolvida;
    }

    @Override
    public double calcular(Entrega entrega) {
        return calculadoraEnvolvida.calcular(entrega);
    }
}
