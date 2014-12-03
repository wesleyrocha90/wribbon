package br.com.ceos.wribbon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

/**
 *
 * @author Wesley
 * @since 29 de Novembro de 2014
 */
public class WRichTooltip extends Control{
  private StringProperty title;
  private ObjectProperty<Image> descriptionImage;
  private ObservableList<String> descriptionSections;
  private ObjectProperty<Image> footerImage;
  private ObservableList<String> footerSections;
  
  private BooleanProperty hasDescriptionImage = new SimpleBooleanProperty(this, "hasDescriptionImage", false);
  private BooleanProperty hasFooterSections = new SimpleBooleanProperty(this, "hasFooterSections", false);
  
  public WRichTooltip(String title){
    titleProperty().set(title);
  }
  
  public WRichTooltip(String title, String descriptionSection){
    titleProperty().set(title);
    descriptionSectionsProperty().add(descriptionSection);
  }
  
  public final StringProperty titleProperty(){
    if(title == null) title = new SimpleStringProperty(this, "title", "");
    return title;
  }
  
  public final String getTitle(){
    return titleProperty().get();
  }
  
  public final void setTitle(String title){
    titleProperty().set(title);
  }
  
  public final ObjectProperty<Image> descriptionImageProperty(){
    if(descriptionImage == null) descriptionImage = new SimpleObjectProperty<>();
    return descriptionImage;
  }
  
  public final Image getDescriptionImage(){
    return descriptionImageProperty().get();
  }
  
  public final void setDescriptionImage(Image descriptionImage){
    hasDescriptionImage.set(true);
    descriptionImageProperty().set(descriptionImage);
  }
  
  public final ObservableList<String> descriptionSectionsProperty(){
    if(descriptionSections == null) descriptionSections = FXCollections.<String>observableArrayList();
    return descriptionSections;
  }
  
  public final ObservableList getDescriptionSections(){
    return descriptionSections;
  }
  
  public final void addDescriptionSections(String descriptionSection){
    descriptionSectionsProperty().add(descriptionSection);
  }
  
  public final ObjectProperty<Image> footerImageProperty(){
    if(footerImage == null) footerImage = new SimpleObjectProperty<>();
    return footerImage;
  }
  
  public final Image getFooterImage(){
    return footerImageProperty().get();
  }
  
  public final void setFooterImage(Image footerImage){
    hasFooterSections.set(true);
    footerImageProperty().set(footerImage);
  }
  
  public final ObservableList<String> footerSectionsProperty(){
    if(footerSections == null) footerSections = FXCollections.<String>observableArrayList();
    return footerSections;
  }
  
  public final ObservableList getFooterSections(){
    return footerSections;
  }
  
  public final void addFooterSections(String footerSection){
    hasFooterSections.set(true);
    footerSectionsProperty().add(footerSection);
  }
  
  public final boolean hasDescriptionImage(){
    return hasDescriptionImage.get();
  }
  
  public final boolean hasFooterSections(){
    return hasFooterSections.get();
  }
  
  @Override
  protected Skin<?> createDefaultSkin() {
    return new WRichTooltipSkin(this);
  }
}
