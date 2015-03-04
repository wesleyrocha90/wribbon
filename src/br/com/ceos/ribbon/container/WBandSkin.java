package br.com.ceos.ribbon.container;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Wesley
 * @since February 25th 2015
 */
public class WBandSkin extends SkinBase<WBand>{
  private final double titleContainerHeight = 30;
  
  private WBandPane bandPane = new WBandPane();
  private BorderPane container;
  
  public WBandSkin(WBand control){
    super(control);
    control.setMaxWidth(Region.USE_PREF_SIZE);
    control.setMaxHeight(Region.USE_PREF_SIZE);
    control.setMinWidth(Region.USE_PREF_SIZE);
    control.setMinHeight(Region.USE_PREF_SIZE);
    bandPane.getChildren().addAll(control.getButtons());
  }
  
  public void updateContainer(double width, double height){
    container = new BorderPane();
    
    Label title = new Label(getSkinnable().getTitle());
    StackPane titleContainer = new StackPane(title);
    titleContainer.setMinHeight(titleContainerHeight);
    titleContainer.setPrefHeight(titleContainerHeight);
    titleContainer.setMaxHeight(titleContainerHeight);
    
    container.setCenter(bandPane);
    container.setBottom(titleContainer);
  }
  
  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateContainer(contentWidth, contentHeight);
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
  
  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return leftInset + bandPane.computePrefHeight(-1) + titleContainerHeight + rightInset;
//    return leftInset + bandPane.getPrefHeight() + rightInset;
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + bandPane.computePrefWidth(-1) + bottomInset;
//    return topInset + bandPane.getPrefWidth() + bottomInset;
  }
}
