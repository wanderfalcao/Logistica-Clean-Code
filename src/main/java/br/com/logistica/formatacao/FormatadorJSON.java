package br.com.logistica.formatacao;

import br.com.logistica.model.Entrega;

import java.util.Locale;

public class FormatadorJSON implements FormatadorEtiqueta {

    @Override
    public String formatar(Entrega entrega, double valorFrete) {
        return String.format(Locale.US, "{ \"destinatario\": \"%s\", \"valor\": %.2f }",
                entrega.destinatario(), valorFrete);
    }
}
