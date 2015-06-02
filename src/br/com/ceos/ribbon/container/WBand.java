package br.com.ceos.ribbon.container;

import br.com.ceos.ribbon.componet.WItem;
import impl.br.com.ceos.ribbon.skin.WBandSkin;
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
public class WBand extends Control{
  
  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  public WBand(String texto) {
    setTexto(texto);
  }
  
  public WBand(String texto, WItem... itens) {
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
  
  private ObservableList<WItem> itens = FXCollections.observableArrayList();
  public final ObservableList<WItem> getItens(){ return this.itens; }
  public final void setItens(ObservableList<WItem> itens){ this.itens.setAll(itens); }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new WBandSkin(this);
  }

  /***************************************************************************
   *                                                                         *
   * Stylesheet Handling                                                     *
   *                                                                         *
   ***************************************************************************/
}
