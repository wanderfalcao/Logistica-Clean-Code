package br.com.logistica.calculo; 

public abstract class CalculadoraFreteDecorator implements CalculadoraFrete { 
    protected final CalculadoraFrete calculadoraEnvolvida; 
    public CalculadoraFreteDecorator(CalculadoraFrete calculadoraEnvolvida) { 
        this.calculadoraEnvolvida = calculadoraEnvolvida; 
    } 
} 
