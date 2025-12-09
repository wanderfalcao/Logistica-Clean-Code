package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;

public class FreteExpresso implements CalculadoraFrete {
    private static final double FATOR = 1.5; 
    private static final double TAXA = 10.0; 
    @Override 
    public double calcular(Entrega entrega) { return (entrega.peso() * FATOR) + TAXA; }
} 
