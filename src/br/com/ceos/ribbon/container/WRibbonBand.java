package br.com.ceos.ribbon.container;

import br.com.ceos.ribbon.componet.WRibbonItem;
import impl.br.com.ceos.ribbon.skin.WRibbonBandSkin;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 *
 * @author Wesley
 * @since February 24th 2015
 */
public class WRibbonBand extends Control{
  
  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  public WRibbonBand(String texto) {
    setTexto(texto);
  }
  
  public WRibbonBand(String texto, WRibbonItem... itens) {
    setTexto(texto);
    setItens(FXCollections.observableArrayList(itens));
  }

  /***************************************************************************
   *                                                                         *
   * Properties                                                              *
   *                                                                         *
   ***************************************************************************/
  
  private StringProperty texto;
  public StringProperty textoProperty() {
    return texto != null ? texto : (texto = new SimpleStringProperty(this, "texto", ""));
  }
  public final String getTexto() { return textoProperty().get(); }
  public final void setTexto(String texto) { textoProperty().set(texto); }
  
  private ObservableList<WRibbonItem> itens = FXCollections.observableArrayList();
//  public ListProperty<WRibbonItem> itensProperty(){
//    return itens != null ? itens : (itens = new SimpleListProperty<>(this, "itens"));
//  }
  public final ObservableList<WRibbonItem> getItens(){ return this.itens; }
  public final void setItens(ObservableList<WRibbonItem> itens){ this.itens.setAll(itens); }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new WRibbonBandSkin(this);
  }

  /***************************************************************************
   *                                                                         *
   * Stylesheet Handling                                                     *
   *                                                                         *
   ***************************************************************************/
}
