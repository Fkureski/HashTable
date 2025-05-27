# Hash Table

Este projeto implementa uma **Hash Table** utilizando **encadeamento separado** como método de tratamento de colisões. A tabela possui fator de carga de 75% e é inicializada com 8 índices, podendo sofrer redimensionamento e rehashing para até 32 índices.

## Entregáveis
Projeto realizado por: Felipe Kureski e Tiago Prestes
- Código fonte organizado conforme P.O.O
- Relatório em PDF com os dados gerados no console, na pasta `relatorio`

> 📚 O projeto foi desenvolvido para a disciplina de **Estrutura de Dados**. Logo, todas as estruturas e métodos foram implementados do zero, sem uso de bibliotecas prontas.

## Funcionalidades

Este é um programa simples e que tem como propósito mensurar a performance de diferentes funções hash. Nesse sentido, a execução do `Main.java` ocasiona a impressão no console de informações como o número de colisões e a velocidade de inserção e busca para cada tabela.

## Estrutura de código

### Função Hash (Length)
A função hash calcula o índice de armazenamento da chave a partir do comprimento da chave (quantidade de caracteres), aplicando o módulo pela capacidade da tabela hash.

```java
@Override
protected int hash(String chave) {
    return chave.length() % capacidade;
}
```

### Função Hash (Unicode)
A função hash calcula o índice de armazenamento da chave somando os códigos Unicode de cada caractere da chave (string) e aplicando o módulo pela capacidade da tabela hash.

```java
@Override
protected int hash (String chave) {
    int soma = 0;
    for (int i = 0; i < chave.length(); i++) {
        soma += chave.charAt(i);
    }
    return soma % capacidade;
}
```
