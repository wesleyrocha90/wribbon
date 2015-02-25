package br.com.ceos.ribbon.container;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Wesley
 */
public class WBand extends Pane{
  
  private final double spacing = 2;
  private final double topInset = 5;
  private final double bottomInset = 5;
  private final double leftInset = 5;
  private final double rightInset = 5;

  public WBand() {
    this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
  }
  
  @Override
  protected void layoutChildren() {
    double currentX = leftInset;
    for(Node node : getChildren()){
      double width = node.prefWidth(-1);
      double height = node.prefHeight(-1);
      layoutInArea(node, currentX, topInset, width, height, 0, HPos.CENTER, VPos.CENTER);
      currentX += width + spacing; 
    }
  }
  
  @Override
  protected double computePrefHeight(double width) {
    return topInset + 100 + bottomInset;
  }

  @Override
  protected double computePrefWidth(double height) {
    double width = 0;
    for(Node node : getChildren()){
      width += node.prefWidth(-1);
    }
    double cumulatedSpacing = 0;
    if(getChildren().size() > 1){
      cumulatedSpacing = (getChildren().size() - 1) * spacing;
    }
    return leftInset + width + cumulatedSpacing + rightInset;
  }
  
  @Override
  protected double computeMaxHeight(double width) {
    return computePrefHeight(width);
  }

  @Override
  protected double computeMaxWidth(double height) {
    return computePrefWidth(height);
  }

  @Override
  protected double computeMinHeight(double width) {
    return computePrefHeight(width);
  }

  @Override
  protected double computeMinWidth(double height) {
    return computePrefWidth(height);
  }
}
