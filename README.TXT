
------------------------------------------------------------------------
-- Regras da Joaninha --
------------------------------------------------------------------------

- A Jô sempre se move na direção da cara dela.
- Se a Jô se mover para depois da borda, ela aparece do outro lado do tabuleiro.
- A Jô não pode se mover por cima das árvores
- A Jô pode empurrar os cogumelos, apenas se não tiver outra coisa atrás.
- A Jô pode pegar e colocar folhas pelo tabuleiro.

- Para trabalhar com a inicialização dos objetos no mundo, é preciso alterar o arquivo:
  WorldSetup.txt

Alí dentro, as primeiras três linhas são:
World: Kara 01 Português Brasileiro
X: 10
Y: 10
  . que significam, respectivamente:
    - Título
    - Tamanho do tabuleiro no eixo X (horizontal)
    - Tamanho do tabuleiro no eixo Y (vertical)
Depois disso, as demais linhas indicam o eixo X e Y que os objetos aparecerão.
+	(sinal de mais)	=> coloca um tesouro com número aleatório de 0 a 100
.	(sinal ponto)	=> coloca uma folha
#	(sinal quadrado)=> coloca uma árvore
@	(sinal arroba)	=> coloca uma Joaninha
Exemplo abaixo:
---------------


+      +
  #
@ # #  #.
    ..    +
     #. +
 +



------------------------------------------------------------------------
Author: Marco Jakob (http://edu.makery.ch)
Version: GreenfootKara 2.0.0
Tradução e Adaptação: Marcelo T. Pereira (http://umuarama.ifpr.edu.br)
