package br.com.ceos.wribbon;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import java.util.Collections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * O Skin para o {@link WRichTooltip}
 * 
 * @author Wesley
 * @since 01 de Dezembro de 2014
 */
public class WRichTooltipSkin extends BehaviorSkinBase<WRichTooltip, BehaviorBase<WRichTooltip>> {

  private final VBox container;

  public WRichTooltipSkin(WRichTooltip control) {
    super(control, new BehaviorBase<>(control, Collections.<KeyBinding>emptyList()));
    container = new VBox();
    getChildren().add(container);
    updateWRichTooltip();
  }

  private void updateWRichTooltip() {
    container.getChildren().clear();

    container.setFillWidth(true);
    container.setPadding(new Insets(10));
    container.setSpacing(5);
    container.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    container.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

    if (getSkinnable().imagemDescricaoProperty().get() != null) {
      if (getSkinnable().imagemDescricaoProperty().get().getWidth() <= 100) {
        container.setPrefWidth(300);
        container.setMaxWidth(300);
        container.setMinWidth(300);
      } else {
        container.setPrefWidth(300 + getSkinnable().imagemDescricaoProperty().get().getWidth());
        container.setMaxWidth(300 + getSkinnable().imagemDescricaoProperty().get().getWidth());
        container.setMinWidth(300 + getSkinnable().imagemDescricaoProperty().get().getWidth());
      }
    } else if (getSkinnable().imagemRodapeProperty().get() != null || getSkinnable().getSecoesRodape().size() > 0) {
      container.setPrefWidth(240);
      container.setMaxWidth(240);
      container.setMinWidth(240);
    } else {
      container.setPrefWidth(180);
      container.setMaxWidth(180);
      container.setMinWidth(180);
    }
    
    container.setMinHeight(Region.USE_PREF_SIZE);
    container.setPrefHeight(Region.USE_COMPUTED_SIZE);
    container.setMaxHeight(Double.MAX_VALUE);

    if (getSkinnable().tituloProperty().get() != null) {
      updateTitulo();
    }
    if (getSkinnable().imagemDescricaoProperty().get() != null || getSkinnable().getSecoesDescricao().size() > 0) {
      updateDescricao();
    }
    if (getSkinnable().imagemRodapeProperty().get() != null || getSkinnable().getSecoesRodape().size() > 0) {
      container.getChildren().add(new Separator(Orientation.HORIZONTAL));
      updateRodape();
    }
  }

  private void updateTitulo() {
    Label labelTitulo = new Label(getSkinnable().getTitulo());
    labelTitulo.setFont(Font.font("System", FontWeight.BOLD, 12));
    labelTitulo.setWrapText(true);
    container.getChildren().add(labelTitulo);
  }

  private void updateDescricao() {
    HBox painel = new HBox();
    painel.setSpacing(10);

    Image imagem = getSkinnable().imagemDescricaoProperty().get();
    if (imagem != null) {
      painel.getChildren().add(new ImageView(imagem));
    }

    ObservableList<String> secoesDescricao = getSkinnable().getSecoesDescricao();
    if (secoesDescricao != null && secoesDescricao.size() > 0) {
      VBox painelSecoes = new VBox(10);
      secoesDescricao.forEach((string) -> {
        Label labelSecao = new Label(string);
        labelSecao.setWrapText(true);
        painelSecoes.getChildren().add(labelSecao);
      });
      painelSecoes.setMinHeight(Region.USE_PREF_SIZE);
      painelSecoes.setPrefHeight(Region.USE_COMPUTED_SIZE);
      painelSecoes.setMaxHeight(Double.MAX_VALUE);
      painel.getChildren().add(painelSecoes);
    }

    container.getChildren().add(painel);
  }

  private void updateRodape() {
    HBox painel = new HBox();
    painel.setSpacing(10);

    Image imagem = getSkinnable().imagemRodapeProperty().get();
    if (imagem != null) {
      painel.getChildren().add(new ImageView(imagem));
    }

    ObservableList<String> secoesRodape = getSkinnable().getSecoesRodape();
    if (secoesRodape != null && secoesRodape.size() > 0) {
      VBox painelSecoes = new VBox(10);
      secoesRodape.forEach((string) -> {
        Label labelSecao = new Label(string);
        labelSecao.setFont(Font.font("System", FontWeight.BOLD, 12));
        labelSecao.setTextFill(Color.BLUE);
        labelSecao.setWrapText(true);
        painelSecoes.getChildren().add(labelSecao);
      });
      painelSecoes.setMinHeight(Region.USE_PREF_SIZE);
      painelSecoes.setPrefHeight(Region.USE_COMPUTED_SIZE);
      painelSecoes.setMaxHeight(Double.MAX_VALUE);
      painel.getChildren().add(painelSecoes);
    }

    container.getChildren().add(painel);
  }
}
