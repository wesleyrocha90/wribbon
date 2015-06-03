package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ItemTest extends Application {

  private WItem item1, item2, item3, item4, item5, item6;

  private Node criaRibbon() {
    FlowPane ribbon = new FlowPane();
    ribbon.setOrientation(Orientation.VERTICAL);
//    ribbon.setHgap(5);
//    ribbon.setVgap(5);
    ribbon.setMaxHeight(85);
    ribbon.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

    item1 = new WItem("Colar Especial", new Image("Paste_32.png"), WItemKind.BIG);
    item2 = new WItem("Recortar", new Image("Paste_32.png"), WItemKind.SMALL);
    item3 = new WItem("Copiar", new Image("Paste_32.png"), WItemKind.SMALL);
    item4 = new WItem("Formatar Pincel", new Image("Paste_32.png"), WItemKind.SMALL);
    item5 = new WItem("Botão", new Image("Paste_32.png"), WItemKind.SMALL);
    item6 = new WItem("Botão", new Image("Paste_32.png"), WItemKind.SMALL);
    
    ribbon.getChildren().addAll(item1, item2, item3, item4, item5, item6);
    return ribbon;
  }

  private Node criaPainelCentral() {
    Button botao1 = new Button("Troca texto do item1");
    botao1.setOnAction(event -> item1.setTexto("Texto trocado por um bem grande"));
    
    VBox tabRoot = new VBox(botao1);
    return new TabPane(new Tab("Cliente", tabRoot), new Tab("Vendas"));
  }

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane root = new BorderPane();
    root.setTop(criaRibbon());
    root.setCenter(criaPainelCentral());

    Scene scene = new Scene(root, 400, 200);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
