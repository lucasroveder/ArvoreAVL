Desafio para a matéria de Algoritimos de Pesquisa e Ordenação

O desafio consistia em desenvolver uma Árvore AVL que seria testada com os seguintes comandos:
- insert
    -> Insere um número, avalia o fator de balanceamento e, caso necessário, faz o balanceamento da árvore
- inOrder, preOrder, posOrder
    -> São diferentes comandos que retornam os elementos da árvore AVL em diferentes ordens sendo: <br/>
      ! inOrder: subárvore esquerda - nó - subárvore direita <br/>
      ! preOrder: nó - subárvore esquerda - subárvore direita <br/>
      ! posOrder: subárvore esquerda - subárvore direita - nó
- search
  -> Retorna um boolean caso o valor informado existe dentro da árvore
- remove
  -> Remove o elemento e, se necessário, faz todo rebalanceamento da árvore

Além desses métodos, no código há vários outros feitos para ajudar esses comandos principais como por exemplo, o height e os comandos de rotations que são comandos mais lógicos para o auto-balanceamento da árvore AVL funcionar
