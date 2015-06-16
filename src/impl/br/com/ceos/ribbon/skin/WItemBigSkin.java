package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.componet.enumeration.WCommandKind;
import br.com.ceos.ribbon.util.SVGUtils;
import br.com.ceos.ribbon.util.StringUtils;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WItemBigSkin extends SkinBase<WItem> {

  private final double PREF_HEIGHT = 80;

  private VBox container;
  private StackPane iconeContainer;
  private VBox textoContainer;
  private ImageView icone;
  private Label textoLinhaUm;
  private Label textoLinhaDois;

  public WItemBigSkin(WItem control) {
    super(control);

    updateItem();
  }

  private void updateItem() {
    updateIconeContainer();
    updateTextoContainer();

    container = new VBox(iconeContainer, textoContainer);
    container.setSpacing(5);
    container.setPadding(new Insets(5));

    container.setOnMouseClicked(event -> getSkinnable().fireEvent(new ActionEvent()));
    getChildren().clear();
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
    textoLinhaUm = new Label();
    textoLinhaDois = new Label();
    textoLinhaUm.textProperty().bind(Bindings.createStringBinding(
        () -> StringUtils.splitInTwo(getSkinnable().textoProperty().get())[0], getSkinnable().textoProperty()));
    textoLinhaDois.textProperty().bind(Bindings.createStringBinding(
        () -> StringUtils.splitInTwo(getSkinnable().textoProperty().get())[1], getSkinnable().textoProperty()));

    textoContainer = new VBox(textoLinhaUm);
    if (getSkinnable().getTipoComando() != WCommandKind.ACAO_SOMENTE) {
      StackPane trianglePopupContainer = new StackPane(SVGUtils.triangleUpsideDown());
      trianglePopupContainer.setPrefHeight(10);
      if (!StringUtils.isEmpty(textoLinhaDois.getText())) {
        HBox linhaDoisContainer = new HBox(2, textoLinhaDois, trianglePopupContainer);
        linhaDoisContainer.setAlignment(Pos.CENTER);
        textoContainer.getChildren().add(linhaDoisContainer);
      } else {
        textoContainer.getChildren().add(trianglePopupContainer);
      }
    } else if (!StringUtils.isEmpty(textoLinhaDois.getText())) {
      textoContainer.getChildren().add(textoLinhaDois);
    }

    textoContainer.setAlignment(Pos.TOP_CENTER);
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateItem();
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }

  @Override
  protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
    return topInset + PREF_HEIGHT + bottomInset;
  }
}