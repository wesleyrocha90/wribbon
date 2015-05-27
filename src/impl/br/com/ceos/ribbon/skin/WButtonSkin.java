package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WButton;
import br.com.ceos.ribbon.util.StringUtils;
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
  
  private BorderStroke borderIcon = new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2));
  private BackgroundFill backIcon = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
  private BorderStroke borderText = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2));
  private BackgroundFill backText = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
  
  private VBox container;
  private VBox iconContainer;
  private VBox textContainer;
  private ImageView iconView;
  private Text upperText;
  private Text lowerText;
  
  public WButtonSkin(WButton control){
    super(control);
    control.setMinHeight(Region.USE_PREF_SIZE);
    control.setMinWidth(Region.USE_PREF_SIZE);
    control.setMaxHeight(Region.USE_PREF_SIZE);
    control.setMaxWidth(Region.USE_PREF_SIZE);
    configureIcon();
    configureText();
  }
  
  private void configureIcon(){
    iconView = new ImageView(getSkinnable().getIcon());
  }
  
  private void configureText(){
    String[] texts = StringUtils.splitInTwo(getSkinnable().getText());
    upperText = new Text(texts[0]);
    lowerText = new Text(texts[1]);
  }
  
  public void updateWButton(double width, double height){
    if(container != null){
      getChildren().remove(container);
    }
    iconContainer = new VBox(iconView);
    iconContainer.setMinSize(width, 50);
    iconContainer.setPrefSize(width, 50);
    iconContainer.setMaxSize(width, 50);
    iconContainer.setBorder(new Border(borderIcon));
    iconContainer.setBackground(new Background(backIcon));
    
    textContainer = new VBox(upperText, lowerText);
    textContainer.setMinSize(width, 50);
    textContainer.setPrefSize(width, 50);
    textContainer.setMaxSize(width, 50);
    textContainer.setBorder(new Border(borderText));
    textContainer.setBackground(new Background(backText));
    
    container = new VBox(iconContainer, textContainer);
    getChildren().add(container);
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateWButton(contentWidth, contentHeight);
    layoutInArea(textContainer, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
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