package br.com.ceos.ribbon.componet.enumeration;

/**
 * Enumeração dos tipos de botões disponíveis.
 * 
 * @author Wesley
 * @since 05 de Dezembro de 2014
 */
public enum WCommandButtonKind {
  
  /**
   * Botão que possui apenas uma área clicável que ativa sua ação
   */
  ACAO_SOMENTE(true, false),
  
  /**
   * Botão que possui apenas uma área clicável que ativa seu popup
   */
  POPUP_SOMENTE(false, true),
  
  /**
   * Botão que possui duas áreas clicáveis, sendo que a principal ativa sua ação
   */
  ACAO_E_POPUP_PRINCIPAL_ACAO(true, true),
  
  /**
   * Botão que possui duas áreas clicáveis, sendo que a principal ativa seu popup
   */
  ACAO_E_POPUP_PRINCIPAL_POPUP(true, true);
  
  /**
   * {@code true} se o botão possui uma ação
   */
  private final boolean acao;
  
  /**
   * {@code true} se o botão possui um popup
   */
  private final boolean popup;
  
  /**
   * Cria um novo tipo de botão
   * @param acao - se o botão possui uma ação
   * @param popup - se o botão possui um popup
   */
  private WCommandButtonKind(boolean acao, boolean popup){
    this.acao = acao;
    this.popup = popup;
  }
  
  public boolean isAcao(){
    return acao;
  }
  
  public boolean isPopup(){
    return popup;
  }
}
