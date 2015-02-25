package br.com.ceos.ribbon.componet;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since February 20th 2015
 */
public class WButtonSkin extends SkinBase<WButton>{
  private Rectangle rectangle;
  
  public WButtonSkin(WButton control){
    super(control);
    control.setMaxWidth(Region.USE_PREF_SIZE);
    control.setMaxHeight(Region.USE_PREF_SIZE);
    control.setMinWidth(Region.USE_PREF_SIZE);
    control.setMinHeight(Region.USE_PREF_SIZE);
    
    control.backgroundFillProperty().addListener(observable -> updateRectangleColor());
  }
  
  private void updateRectangle(double width, double height){
    if(rectangle != null){
      getChildren().remove(rectangle);
    }
    rectangle = new Rectangle(width, height);
    rectangle.setFill(getSkinnable().getBackgroundFill());
    getChildren().add(rectangle);
  }
  
  private void updateRectangleColor(){
    if(rectangle != null){
      rectangle.setFill(getSkinnable().getBackgroundFill());
      getSkinnable().requestLayout();
    }
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateRectangle(contentWidth, contentHeight);
    layoutInArea(rectangle, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
  
  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return leftInset + 70 + rightInset;
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + 40 + bottomInset;
  }
}
