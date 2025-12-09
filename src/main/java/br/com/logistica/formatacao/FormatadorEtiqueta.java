package br.com.logistica.formatacao;

import br.com.logistica.model.Entrega;

public interface FormatadorEtiqueta {
    String formatar(Entrega entrega, double valorFrete);
} 
