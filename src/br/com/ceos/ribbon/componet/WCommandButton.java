package br.com.ceos.ribbon.componet;

import br.com.ceos.ribbon.componet.enumeration.WCommandButtonDisplayState;
import br.com.ceos.ribbon.componet.enumeration.WCommandButtonKind;
import br.com.ceos.ribbon.icon.WResizableIcon;
import javafx.scene.control.Button;

/**
 *
 * @author Wesley
 * @since 04 de Dezembro de 2014
 */
public class WCommandButton extends WAbstractButton {

  private String texto;
  private WResizableIcon icone;
  private WRichTooltip tooltip;
  private WCommandButtonKind tipoBotao;
  private WCommandButtonDisplayState estadoBotao;

  public void setDica(WRichTooltip tooltip) {
    this.tooltip = tooltip;
  }
}
