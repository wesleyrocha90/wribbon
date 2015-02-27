package br.com.ceos.ribbon.componet;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Wesley
 * @since February 20th 2015
 */
public class WButtonSkin extends SkinBase<WButton>{
  private final double iconContainerHeight = 120; // 40
  private final double textContainerHeight = 90; // 30
  private final double width = 120; // 40
  private final Color background = Color.WHITE;
  private final Color backgroundHover = Color.AQUA;
  private final Color backgroundArmed = Color.LIGHTBLUE;
  
  private VBox container;
  private Rectangle textContainer;
  private Rectangle iconContainer;
  
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
    iconContainer = new Rectangle(width, iconContainerHeight);
    iconContainer.setFill(background);
    iconContainer.addEventHandler(MouseEvent.MOUSE_ENTERED, (event) -> iconContainer.setFill(backgroundHover));
    iconContainer.addEventHandler(MouseEvent.MOUSE_EXITED, (event) -> iconContainer.setFill(background));
    iconContainer.addEventHandler(MouseEvent.MOUSE_PRESSED, (event) -> iconContainer.setFill(backgroundArmed));
    iconContainer.addEventHandler(MouseEvent.MOUSE_RELEASED, (event) -> iconContainer.setFill(background));
  }
  
  private void updateTextContainer(){
    textContainer = new Rectangle(width, textContainerHeight);
    textContainer.setFill(background);
    textContainer.addEventHandler(MouseEvent.MOUSE_ENTERED, (event) -> textContainer.setFill(backgroundHover));
    textContainer.addEventHandler(MouseEvent.MOUSE_EXITED, (event) -> textContainer.setFill(background));
    textContainer.addEventHandler(MouseEvent.MOUSE_PRESSED, (event) -> textContainer.setFill(backgroundArmed));
    textContainer.addEventHandler(MouseEvent.MOUSE_RELEASED, (event) -> textContainer.setFill(background));
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateRectangle(contentWidth, contentHeight);
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
  
  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return leftInset + iconContainerHeight + textContainerHeight + rightInset;
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + width + bottomInset;
  }
}
