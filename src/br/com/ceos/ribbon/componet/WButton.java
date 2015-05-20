package br.com.ceos.ribbon.componet;

import impl.br.com.ceos.ribbon.skin.WButtonSkin;
import br.com.ceos.ribbon.componet.enumeration.WButtonDisplayState;
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
 * @since December 4th 2014
 */
public class WButton extends Control{
  
  private StringProperty text;
  private ObjectProperty<Image> icon;
  
  public WButton(String text){
    textProperty().set(text);
  }
  
  public WButton(String text, Image icon){
    textProperty().set(text);
    iconProperty().set(icon);
  }
  
  public final StringProperty textProperty(){
    return text == null ? text = new SimpleStringProperty(text, "text", "") : text;
  }
  public final String getText(){ return textProperty().get(); }
  public final void setText(String text){ textProperty().set(text); }
  
  public final ObjectProperty<Image> iconProperty(){
    return icon == null ? icon = new SimpleObjectProperty<>(icon, "icon", null) : icon;
  }
  public final Image getIcon(){ return iconProperty().get(); }
  public final void setIcon(Image icon){ iconProperty().set(icon); }
  
  @Override
  protected Skin<?> createDefaultSkin() {
    return new WButtonSkin(this);
  }
  
  @Override
  public String toString(){
    StringBuilder string = new StringBuilder();
    string.append("WButton [");
    string.append("text:").append(text);
    string.append("]");
    return string.toString();
  }
}