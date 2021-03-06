package br.com.ceos.ribbon.componet.enumeration;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.container.WBand;

/**
 * Como os itens serão exibidos no Ribbon
 * 
 * @author Wesley
 * @since May 28th 2015
 */
public enum WItemKind {
  
  /**
   * O {@link WItem Item} é exibido com uma altura que ocupa as três linhas do layout da 
   * {@link WBand Banda}. Ele é exibido com o ícone na parte superior e o texto na inferior.
   */
  BIG(3),

  /**
   * O {@link WItem Item} é exibido com uma altura que ocupa duas linhas do layout da 
   * {@link WBand Banda}. Ele é exibido com o ícone a esquerda e o texto a direita.
   */
  MEDIUM(2),
  
  /**
   * O {@link WItem Item} é exibido com uma altura que ocupa apenas uma linha do layout da 
   * {@link WBand Banda}. Ele é exibido com o ícone a esquerda e o texto a direita.
   */
  SMALL(1),
  
  /**
   * O {@link WItem Item} é exibido com uma altura que ocupa apenas uma linha do layout da 
   * {@link WBand Banda}. Apenas o ícone é exibido neste caso.
   */
  ICON(1),
    
  /**
   * O {@link WItem Item} é exibido com uma altura fixa, essa exibição é usada apenas nos menus. 
   * Uma descrição é exibida abaixo do Título do {@link WItem Item} neste caso.
   */
  TILE(2);
  
  private final int peso;
  
  private WItemKind(int peso){
    this.peso = peso;
  }
  
  public int getPeso(){
    return this.peso;
  }
}
