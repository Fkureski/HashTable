# Hash Table

Este projeto implementa uma **Hash Table** com capacidade de 32 índices, utilizando **encadeamento separado** como método de tratamento de colisões.

> 📚 O projeto foi desenvolvido para a disciplina de **Estrutura de Dados**. Logo, todas as estruturas e métodos foram implementados do zero, sem uso de bibliotecas prontas.

## Funcionalidades

Este é um programa simples e que tem como propósito mensurar a performance de diferentes funções hash. Nesse sentido, a execução do `Main.java` ocasiona a impressão no console de informações como o número de colisões e a velocidade de inserção e busca para cada tabela.

## Estrutura de código

### Função Hash (Length)
A função hash calcula o índice de armazenamento da chave a partir do comprimento da chave (quantidade de caracteres), aplicando o módulo pela capacidade da tabela hash (32).

```java
@Override
protected int hash(String chave) {
    return chave.length() % capacidade;
}
```

### Função Hash (ASCII)
A função hash calcula o índice de armazenamento da chave somando os códigos Unicode de cada caractere da chave (string) e aplicando o módulo pela capacidade da tabela hash (32).

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
