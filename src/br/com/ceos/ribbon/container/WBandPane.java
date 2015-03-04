package br.com.ceos.ribbon.container;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Wesley
 * @since February 2nd 2015
 */
public class WBandPane extends Pane {
  private final double prefHeight = 70;
  private final double spacing = 5;
  private final double topInset = 5;
  private final double bottomInset = 5;
  private final double leftInset = 5;
  private final double rightInset = 5;

  public WBandPane() {
    super();
    this.backgroundProperty().set(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
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
    return topInset + prefHeight + bottomInset;
  }

  @Override
  protected double computePrefWidth(double height) {
    double width = 0;
    width = getChildren().stream().map((node) -> node.prefWidth(-1))
            .reduce(width, (accumulator, _item) -> accumulator + _item);
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
