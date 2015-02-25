package br.com.ceos.ribbon.componet;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Wesley
 * @since December 4th 2014
 */
public class WButton extends Control{
  
  private ObjectProperty<Paint> backgroundFill;
  
  public WButton(){
    backgroundFill = new SimpleObjectProperty<>(Color.AQUA);
  }
  
  public ObjectProperty<Paint> backgroundFillProperty(){ return backgroundFill; }
  public Paint getBackgroundFill(){ return backgroundFill.get(); }
  public void setBackgroundFill(Paint backgroundFill){ this.backgroundFill.set(backgroundFill); }
  
  @Override
  protected Skin<?> createDefaultSkin() {
    return new WButtonSkin(this);
  }
}
