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
 * @since December 4th 2014
 */
public class WTab extends Control{
  
  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  public WTab(String texto) {
    setTexto(texto);
  }
  
  public WTab(String texto, WBand... bands) {
    setTexto(texto);
    setBandas(FXCollections.observableArrayList(bands));
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
  
  private ObservableList<WBand> bands = FXCollections.observableArrayList();
  public final ObservableList<WBand> getBandas(){ return this.bands; }
  public final void setBandas(ObservableList<WBand> bandas){ this.bands.setAll(bandas); }

  /***************************************************************************
   *                                                                         *
   * Stylesheet Handling                                                     *
   *                                                                         *
   ***************************************************************************/
}
