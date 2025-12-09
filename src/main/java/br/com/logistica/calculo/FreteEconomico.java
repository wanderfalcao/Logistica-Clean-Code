package br.com.logistica.calculo;

import br.com.logistica.model.Entrega;

public class FreteEconomico implements CalculadoraFrete {
    private static final double PESO_ISENCAO = 2.0; 
    private static final double FATOR = 1.1; 
    private static final double DESCONTO = 5.0;
    private static final double CUSTO_ZERO = 0.0;
    @Override 
    public double calcular(Entrega entrega) {
        if (entrega.peso() < PESO_ISENCAO) return CUSTO_ZERO;
        return Math.max(CUSTO_ZERO, (entrega.peso() * FATOR) - DESCONTO);
    } 
} 
