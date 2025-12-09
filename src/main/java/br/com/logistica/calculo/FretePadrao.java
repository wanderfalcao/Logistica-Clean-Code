package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;

public class FretePadrao implements CalculadoraFrete {
    private static final double FATOR = 1.2; 
    @Override 
    public double calcular(Entrega entrega) { return entrega.peso() * FATOR; }
} 
