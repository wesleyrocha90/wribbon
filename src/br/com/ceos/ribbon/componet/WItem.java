package br.com.ceos.ribbon.componet;

import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import impl.br.com.ceos.ribbon.skin.WItemBigSkin;
import impl.br.com.ceos.ribbon.skin.WItemIconSkin;
import impl.br.com.ceos.ribbon.skin.WItemMediumSkin;
import impl.br.com.ceos.ribbon.skin.WItemSmallSkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WItem extends Control {

  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  public WItem() {
  }

  public WItem(String texto) {
    textoProperty().set(texto);
  }

  public WItem(String texto, Image icone) {
    textoProperty().set(texto);
    iconeProperty().set(icone);
  }

  public WItem(String texto, Image icone, WItemKind tipo) {
    textoProperty().set(texto);
    iconeProperty().set(icone);
    tipoProperty().set(tipo);
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

  private ObjectProperty<Image> icone;
  public ObjectProperty<Image> iconeProperty() {
    return icone != null ? icone : (icone = new SimpleObjectProperty<>(this, "icone"));
  }
  public final Image getIcone() { return iconeProperty().get(); }
  public final void setIcone(Image icone) { iconeProperty().set(icone); }
  
  private ObjectProperty<WItemKind> tipo;
  public ObjectProperty<WItemKind> tipoProperty() {
    return tipo != null ? tipo : (tipo = new SimpleObjectProperty<>(this, "tipo", WItemKind.BIG));
  }
  public final WItemKind getTipo() { return tipoProperty().get(); }
  public final void setTipo(WItemKind tipo) { tipoProperty().set(tipo); }

  @Override
  protected Skin<?> createDefaultSkin() {
    switch(getTipo()){
      case BIG:
        return new WItemBigSkin(this);
      case MEDIUM:
        return new WItemMediumSkin(this);
      case SMALL:
        return new WItemSmallSkin(this);
      case ICON:
        return new WItemIconSkin(this);
    }
    return new WItemBigSkin(this);
  }

  /***************************************************************************
   *                                                                         *
   * Stylesheet Handling                                                     *
   *                                                                         *
   ***************************************************************************/
}
