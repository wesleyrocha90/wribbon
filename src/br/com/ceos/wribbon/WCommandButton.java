package br.com.ceos.wribbon;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Wesley
 * @since 04 de Dezembro de 2014
 */
public class WCommandButton extends Button{
  private WRichTooltip dica;
  
  public void setDica(WRichTooltip dica){
    this.dica = dica;
  }
  
  
}
