package br.com.ceos.ribbon.componet;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Wesley
 * @since February 20th 2015
 */
public class WButtonSkin extends SkinBase<WButton>{
  private final double iconContainerHeight = 40;
  private final double textContainerHeight = 30;
  private final double width = 40;
  private final double iconSize = 36;
  private final Color background = Color.WHITE;
  private final Color backgroundHover = Color.AQUA;
  private final Color backgroundArmed = Color.LIGHTBLUE;
  
  private VBox container;
  private StackPane textContainer;
  private StackPane iconContainer;
  private Rectangle textRectangle;
  private Rectangle iconRectangle;
  
  public WButtonSkin(WButton control){
    super(control);
    control.setMaxWidth(Region.USE_PREF_SIZE);
    control.setMaxHeight(Region.USE_PREF_SIZE);
    control.setMinWidth(Region.USE_PREF_SIZE);
    control.setMinHeight(Region.USE_PREF_SIZE);
  }
  
  private void updateRectangle(double width, double height){
    if(container != null){
      getChildren().remove(container);
    }
    updateIconContainer();
    updateTextContainer();
    container = new VBox(0);
    container.getChildren().addAll(iconContainer, textContainer);
    getChildren().add(container);
  }
  
  private void updateIconContainer(){
    iconRectangle = new Rectangle(width, iconContainerHeight);
    iconRectangle.setFill(background);
    
    ImageView iconView = new ImageView(getSkinnable().getIcon());
    iconView.setFitHeight(iconSize);
    iconView.setFitWidth(iconSize);
    iconView.setPreserveRatio(true);
    iconView.setSmooth(true);
    iconView.setMouseTransparent(true);
    
    iconContainer = new StackPane(iconRectangle, iconView);
  }
  
  private void updateTextContainer(){
    textRectangle = new Rectangle(width, textContainerHeight);
    textRectangle.setFill(background);
    
    Label label = new Label(getSkinnable().getText());
    label.setMouseTransparent(true);
    
    textContainer = new StackPane(textRectangle, label);
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateRectangle(contentWidth, contentHeight);
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
  
  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + iconContainerHeight + textContainerHeight + bottomInset;
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + width + bottomInset;
  }
}
