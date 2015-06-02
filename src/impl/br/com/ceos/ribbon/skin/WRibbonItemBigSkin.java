package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.util.StringUtils;
import javafx.beans.binding.Bindings;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WRibbonItemBigSkin extends SkinBase<WItem> {

  private final double PREF_WIDTH = 50;
  private final double PREF_HEIGHT = 84;
  
  private VBox container;
  private StackPane iconeContainer;
  private VBox textoContainer;
  private ImageView icone;
  private Text textoLinhaUm;
  private Text textoLinhaDois;

  public WRibbonItemBigSkin(WItem control) {
    super(control);
    updateItem();
  }

  private void updateItem() { 
    if (container != null) {
      getChildren().remove(container);
    }
    updateIconeContainer();
    updateTextoContainer();

    container = new VBox(iconeContainer, textoContainer);
    container.setSpacing(5);
    container.setPadding(new Insets(5));
    container.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    container.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
    
    getChildren().add(container);
  }

  private void updateIconeContainer() {
    icone = new ImageView();
    icone.imageProperty().bind(getSkinnable().iconeProperty());
    icone.setFitHeight(32);
    icone.setFitWidth(32);

    iconeContainer = new StackPane(icone);
  }

  private void updateTextoContainer() {
    textoLinhaUm = new Text();
    textoLinhaDois = new Text();
    textoLinhaUm.textProperty().bind(Bindings.createStringBinding(
        () -> StringUtils.splitInTwo(getSkinnable().textoProperty().get())[0], getSkinnable().textoProperty()));
    textoLinhaDois.textProperty().bind(Bindings.createStringBinding(
        () -> StringUtils.splitInTwo(getSkinnable().textoProperty().get())[1], getSkinnable().textoProperty()));
    
    textoContainer = new VBox(textoLinhaUm, textoLinhaDois);
    textoContainer.setAlignment(Pos.TOP_CENTER);
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