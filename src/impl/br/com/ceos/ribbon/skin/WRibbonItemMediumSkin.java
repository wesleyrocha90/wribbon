package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WRibbonItem;
import br.com.ceos.ribbon.util.StringUtils;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WRibbonItemMediumSkin extends SkinBase<WRibbonItem> {

  private final double PREF_WIDTH = 50;
  private final double PREF_HEIGHT = 25;
  
  private HBox container;
  private StackPane iconeContainer;
  private ImageView icone;
  private StackPane textoContainer;
  private Text texto;

  public WRibbonItemMediumSkin(WRibbonItem control) {
    super(control);
    control.textoProperty().addListener((observable, oldValue, newValue) -> control.requestLayout());
    control.iconeProperty().addListener((observable, oldValue, newValue) -> control.requestLayout());
    
    updateItem();
  }

  private void updateItem() {
    if (container != null) {
      getChildren().remove(container);
    }
    updateIconeContainer();
    updateTextoContainer();

    container = new HBox(iconeContainer, textoContainer);
    container.setSpacing(5);
    container.setPadding(new Insets(5));
    container.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    container.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

    getChildren().add(container);
  }

  private void updateIconeContainer() {
    icone = new ImageView(getSkinnable().getIcone());
    icone.setFitHeight(32);
    icone.setFitWidth(32);

    iconeContainer = new StackPane(icone);
//    iconeContainer.setBackground(new Background(new BackgroundFill(Color.rgb(0xDD, 0xDD, 0xDD), CornerRadii.EMPTY, Insets.EMPTY)));
//    iconeContainer.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
  }

  private void updateTextoContainer() {
    texto = new Text(getSkinnable().getTexto());
    
    textoContainer = new StackPane(texto);
//    textoContainer.setBackground(new Background(new BackgroundFill(Color.rgb(0xDD, 0xDD, 0xDD), CornerRadii.EMPTY, Insets.EMPTY)));
//    textoContainer.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateItem();
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }

  @Override
  protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    return rightInset + PREF_WIDTH + leftInset;
  }

  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + PREF_HEIGHT + bottomInset;
  }
  
}
