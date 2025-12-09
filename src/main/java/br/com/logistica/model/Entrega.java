package br.com.logistica.model;

import br.com.logistica.exception.DadosInvalidosException;

public record Entrega(String endereco, double peso, TipoFrete tipoFrete, String destinatario) { 
    public Entrega { 
        if (endereco == null) throw new DadosInvalidosException("Endereco nulo"); 
        if (tipoFrete == null) throw new DadosInvalidosException("Frete nulo"); 
        if (destinatario == null) throw new DadosInvalidosException("Destinatario nulo"); 
        if (endereco.isBlank()) throw new DadosInvalidosException("Endereco vazio"); 
        if (destinatario.isBlank()) throw new DadosInvalidosException("Destinatario vazio"); 
        if (peso <= 0) throw new DadosInvalidosException("Peso deve ser maior que zero"); 
    } 
}
