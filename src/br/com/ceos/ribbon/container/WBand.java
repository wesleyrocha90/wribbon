package br.com.ceos.ribbon.container;

import br.com.ceos.ribbon.componet.WButton;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

/**
 *
 * @author Wesley
 * @since February 24th 2015
 */
public class WBand extends Control{
  
  private StringProperty title;
  private ObjectProperty<Image> icon;
  private final ObservableList<WButton> buttons = FXCollections.<WButton>observableArrayList();
  
  public WBand(String title, Image icon){
    titleProperty().set(title);
    iconProperty().set(icon);
  }
  
  public final StringProperty titleProperty(){
    return title == null ? title = new SimpleStringProperty(title, "title", "") : title;
  }
  public final String getTitle(){ return titleProperty().get(); }
  public final void setTitle(String title){ titleProperty().set(title); }
  
  public final ObjectProperty<Image> iconProperty(){
    return icon == null ? icon = new SimpleObjectProperty<>(icon, "icon", null) : icon;
  }
  public final Image getIcon(){ return iconProperty().get(); }
  public final void setIcon(Image icon){ iconProperty().set(icon); }
  
  public final ObservableList<WButton> getButtons(){ return buttons; }
    
  public void addButton(WButton button){
    buttons.add(button);
  }
  
  public void addButtons(WButton... buttons){
    this.buttons.addAll(buttons);
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new WBandSkin(this);
  }
  
  @Override
  public String toString(){
    StringBuilder string = new StringBuilder();
    string.append("WBand [");
    string.append("title:").append(title);
    string.append("]");
    return string.toString();
  }
}
