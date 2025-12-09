package br.com.logistica.servico; 
import br.com.logistica.model.Entrega;
import br.com.logistica.calculo.CalculadoraFrete; 
import br.com.logistica.factory.CalculadoraFreteFactory; 
import br.com.logistica.formatacao.*; 
import br.com.logistica.exception.DadosInvalidosException; 
public class EtiquetaService { 
    private final FormatadorEtiqueta formatador; 
    public EtiquetaService() { this.formatador = new FormatadorTextoPadrao(); } 
    public EtiquetaService(FormatadorEtiqueta formatador) { this.formatador = formatador; } 
    public String gerar(Entrega entrega) { 
        if (entrega == null) throw new DadosInvalidosException("Entrega nula"); 
        CalculadoraFrete calc = CalculadoraFreteFactory.criar(entrega.tipoFrete()); 
        double valor = calc.calcular(entrega); 
        return formatador.formatar(entrega, valor); 
    } 
} 
