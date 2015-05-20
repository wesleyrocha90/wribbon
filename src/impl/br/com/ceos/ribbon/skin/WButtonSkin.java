package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WButton;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since February 20th 2015
 */
public class WButtonSkin extends SkinBase<WButton>{

  private StackPane container;
  private Text text;
  private BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2));
  private BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
  
  public WButtonSkin(WButton control){
    super(control);
    control.setMinHeight(Region.USE_PREF_SIZE);
    control.setMinWidth(Region.USE_PREF_SIZE);
    control.setMaxHeight(Region.USE_PREF_SIZE);
    control.setMaxWidth(Region.USE_PREF_SIZE);
    
    text = new Text();
    text.textProperty().bind(control.textProperty());
  }
  
  public void updateWButton(double width, double height){
    if(container != null){
      getChildren().remove(container);
    }
    container = new StackPane(text);
    container.setBackground(new Background(backgroundFill));
    container.setBorder(new Border(borderStroke));
    getChildren().add(container);
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateWButton(contentWidth, contentHeight);
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }

  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + 100 + bottomInset;
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return rightInset + 100 + leftInset;
  }
}