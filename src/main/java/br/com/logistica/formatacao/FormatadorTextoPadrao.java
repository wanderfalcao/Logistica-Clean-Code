package br.com.logistica.formatacao; 
import br.com.logistica.model.Entrega;
import java.text.NumberFormat; 
import java.util.Locale; 
public class FormatadorTextoPadrao implements FormatadorEtiqueta { 
    @Override 
    public String formatar(Entrega entrega, double valorFrete) { 
        String fmt = "Destinatario: %s\nEndereco: %s\nTipo: %s\nValor Total: %s"; 
        return String.format(fmt, 
                entrega.destinatario(), 
                entrega.endereco(), 
                entrega.tipoFrete(), 
                NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valorFrete) 
        ); 
    } 
} 
