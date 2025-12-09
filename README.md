# LogisticaCleanCode - Calculadora de Fretes

Este é um projeto de exemplo em Java que demonstra a implementação de uma calculadora de custos de frete, utilizando princípios de código limpo e padrões de projeto para criar um sistema flexível, manutenível e extensível.

## 🎯 Objetivo

O objetivo principal é calcular o valor do frete para uma entrega com base no seu tipo (Padrão, Expresso, Econômico) e em suas características, como o peso. O projeto foi estruturado para que novas regras de cálculo e promoções possam ser adicionadas facilmente, sem a necessidade de alterar o código existente.

## ✨ Padrões de Projeto e Arquitetura

A arquitetura do sistema é fortemente baseada em três padrões de projeto clássicos:

### 1. Factory Method
- **Onde?** `CalculadoraFreteFactory.java`
- **Por quê?** Centraliza a lógica de criação dos objetos de cálculo. O cliente solicita uma calculadora para um `TipoFrete` específico, e a fábrica decide qual implementação concreta (e quais decoradores) instanciar. Isso desacopla o cliente das classes concretas.

### 2. Strategy
- **Onde?** A interface `CalculadoraFrete.java` e suas implementações (`FretePadrao`, `FreteExpresso`, `FreteEconomico`).
- **Por quê?** Cada classe de cálculo representa uma "estratégia" diferente. O padrão Strategy permite que o algoritmo de cálculo seja selecionado em tempo de execução, tornando o sistema flexível para adicionar novas estratégias sem impactar o código cliente.

### 3. Decorator
- **Onde?** `PromocaoPesoLeve.java` e a classe abstrata `CalculadoraFreteDecorator`.
- **Por quê?** Adiciona responsabilidades a um objeto dinamicamente. A `PromocaoPesoLeve` "decora" uma calculadora de frete para aplicar uma regra de promoção antes de delegar o cálculo final. Isso evita a explosão de subclasses e permite combinar comportamentos de forma flexível.

## 📂 Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- **`br.com.logistica.model`**: Contém as entidades e objetos de valor do domínio.
- **`br.com.logistica.calculo`**: Contém a lógica de negócio (as estratégias de cálculo).
- **`br.com.logistica.factory`**: Contém a lógica de criação de objetos.
- **`br.com.logistica.servico`**: Contém os serviços da aplicação.
- **`br.com.logistica.formatacao`**: Contém as diferentes formas de formatar a etiqueta.
- **`br.com.logistica.exception`**: Contém as exceções customizadas.

## 🧪 Testes

A qualidade e a robustez do código são garantidas por uma suíte de testes unitários utilizando **JUnit 5**. Os testes estão localizados em `src/test/java` e seguem a mesma estrutura de pacotes do código-fonte.

As principais áreas de cobertura são:
- **Validação de Dados**: Garante que a classe `Entrega` rejeita dados inválidos.
- **Lógica de Cálculo**: Testa cada estratégia de frete (`FretePadrao`, `FreteEconomico`, `FreteExpresso`).
- **Decorator de Promoção**: Valida a aplicação correta da `PromocaoPesoLeve`.
- **Factory**: Assegura que a `CalculadoraFreteFactory` cria a instância correta para cada `TipoFrete`.
- **Serviços e Formatação**: Testa o comportamento do `EtiquetaService` e dos formatadores.

### Executando Todos os Testes com a TestSuite

Para facilitar a execução de todos os testes do projeto de uma só vez, foi criada a classe `TestSuite.java`. Ela utiliza anotações do JUnit 5 para agregar todas as classes de teste em uma única suíte.

- **Onde?** `src/test/java/br/com/logistica/TestSuite.java`
- **Como usar?** Simplesmente execute esta classe como um teste JUnit em sua IDE. Ela rodará todos os testes selecionados e fornecerá um relatório consolidado, garantindo que nenhuma parte do sistema foi quebrada após uma alteração.

## ⚙️ Como Usar

A principal forma de interagir com a biblioteca é através da `CalculadoraFreteFactory`. O exemplo abaixo, extraído de um dos testes unitários, demonstra como usar o sistema.

### Exemplo de um Teste Unitário (JUnit 5)

```java
import br.com.logistica.model.Entrega;
import br.com.logistica.model.TipoFrete;
import br.com.logistica.calculo.CalculadoraFrete;
import br.com.logistica.factory.CalculadoraFreteFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExemploDeUsoTest {

    @Test
    void deveCalcularFreteExpressoComPromocao() {
        // 1. Cria o objeto de entrega
        Entrega entrega = new Entrega("Rua A, 123", 12.0, TipoFrete.EXPRESSO, "Cliente A");

        // 2. Usa a Factory para obter a calculadora correta
        CalculadoraFrete calculadora = CalculadoraFreteFactory.criar(entrega.tipoFrete());

        // 3. Executa o cálculo
        double valorFrete = calculadora.calcular(entrega);

        // 4. Valida o resultado esperado
        // A promoção é acionada (peso > 10kg), então o cálculo é: (12.0 - 1.0) * 1.5 + 10.0 = 26.5
        assertEquals(26.5, valorFrete, 0.01);
    }
}
```

## 📜 Regras de Negócio Implementadas

- **Frete Padrão**: `valor = peso * 1.2`
- **Frete Econômico**:
  - Se `peso < 2.0 kg`, o frete é grátis (`R$ 0.0`).
  - Caso contrário, `valor = (peso * 1.1) - 5.0` (com valor mínimo de `R$ 0.0`).
- **Frete Expresso (com Promoção `PromocaoPesoLeve`)**:
  - A calculadora `FreteExpresso` é "decorada" pela `PromocaoPesoLeve`.
  - **Regra da Promoção**: Se `peso > 10.0 kg`, o peso considerado para o cálculo é `peso - 1.0 kg`.
  - **Regra de Cálculo Base**: `valor = peso_considerado * 1.5 + 10.0`.