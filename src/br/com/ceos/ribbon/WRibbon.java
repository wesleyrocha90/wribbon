package br.com.ceos.ribbon;

import br.com.ceos.ribbon.container.WTab;
import impl.br.com.ceos.ribbon.skin.WRibbonSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 *
 * @author Wesley
 * @since 05 de Dezembro de 2014
 */
public class WRibbon extends Control {
  
  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  public WRibbon(WTab... tabs) {
    setTabs(FXCollections.observableArrayList(tabs));
  }

  /***************************************************************************
   *                                                                         *
   * Properties                                                              *
   *                                                                         *
   ***************************************************************************/
  
  private ObservableList<WTab> tabs = FXCollections.observableArrayList();
  public final ObservableList<WTab> getTabs(){ return this.tabs; }
  public final void setTabs(ObservableList<WTab> tabs){ this.tabs.setAll(tabs); }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new WRibbonSkin(this);
  }
}