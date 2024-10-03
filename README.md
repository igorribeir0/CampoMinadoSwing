# Campo Minado

Este projeto implementa um jogo de Campo Minado (Minesweeper) em Java, utilizando os princípios de Orientação a Objetos e a interface gráfica Swing. O jogo é composto por um tabuleiro que contém vários campos, alguns dos quais são minas. O objetivo do jogo é abrir todos os campos sem minas, evitando explosões.

## Estrutura do Projeto

- `Tabuleiro`: Representa o tabuleiro do jogo, contendo uma matriz de `Campo`.
- `Campo`: Representa cada célula do tabuleiro, que pode conter uma mina ou não.
- `CampoObserver`: Interface que permite que um `Campo` notifique mudanças de estado, como abertura, marcação ou explosão.
- `ResultadoEvento`: Classe para encapsular o resultado do jogo (vitória ou derrota).

## Classes e Métodos

### `Tabuleiro`

A classe `Tabuleiro` é responsável por gerenciar os campos do jogo. Ela contém métodos para abrir campos, alterar marcações, gerar campos e sortear minas.

- **Atributos**:
  - `linhas`, `colunas`, `minas`: Dimensões do tabuleiro e número de minas.
  - `campos`: Lista de objetos `Campo` que representam o tabuleiro.
  - `observadores`: Lista de observadores que escutam eventos de resultado do jogo.

- **Métodos**:
  - `paraCadaCampo(Consumer<Campo> funcao)`: Executa uma função em cada campo do tabuleiro.
  - `registarObservadores(Consumer<ResultadoEvento> observador)`: Registra observadores que serão notificados quando o jogo terminar.
  - `abrir(int linha, int coluna)`: Abre um campo específico no tabuleiro.
  - `alterarMarcacao(int linha, int coluna)`: Alterna a marcação de um campo (ex.: bandeira).
  - `reiniciar()`: Reinicia o jogo, sorteando novas minas.
  - `objetivoAlcancado()`: Verifica se o jogador atingiu o objetivo de abrir todos os campos sem minas.
  - `eventoOcorreu(Campo campo, CampoEvento evento)`: Implementa a lógica de evento para tratar explosões ou conclusão do jogo.
  - `mostrarMinas()`: Mostra todas as minas quando o jogo é perdido.

### `Campo`

Cada campo pode ser aberto, marcado (ex.: com uma bandeira) e possui vizinhos. Quando o campo é aberto e contém uma mina, ele dispara um evento de explosão.

- **Eventos**:
  - `CampoEvento.ABRIR`: Quando o campo é aberto.
  - `CampoEvento.MARCAR`: Quando o campo é marcado.
  - `CampoEvento.EXPLODIR`: Quando o campo contém uma mina e explode.

### `CampoObserver`

A interface `CampoObserver` é usada para que a classe `Tabuleiro` observe as mudanças de estado em cada `Campo`.

### `ResultadoEvento`

Essa classe encapsula o resultado do jogo, indicando se o jogador venceu ou perdeu.

### Exemplo de Uso

1. **Inicialização do Tabuleiro**:
   Crie uma instância do tabuleiro, especificando as dimensões e o número de minas:

   ```java
   Tabuleiro tabuleiro = new Tabuleiro(10, 10, 10); // 10 linhas, 10 colunas, 10 minas
