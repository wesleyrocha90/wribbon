package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.util.StyleUtils;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WItemSmallSkin extends SkinBase<WItem> {

  private final double PREF_WIDTH = 50;
  private final double PREF_HEIGHT = 25;
  
  private HBox container;
  private StackPane iconeContainer;
  private ImageView icone;
  private StackPane textoContainer;
  private Text texto;

  public WItemSmallSkin(WItem control) {
    super(control);
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
    icone = new ImageView();
    icone.imageProperty().bind(getSkinnable().iconProperty());
    icone.setFitHeight(16);
    icone.setFitWidth(16);

    iconeContainer = new StackPane(icone);
  }

  private void updateTextoContainer() {
    texto = new Text();
    texto.textProperty().bind(getSkinnable().textProperty());
    
    textoContainer = new StackPane(texto);
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