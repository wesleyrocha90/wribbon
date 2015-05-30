package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WRibbonItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ItemTest extends Application {

  private WRibbonItem item1, item2, item3, item4, item5, item6, item7, item8, item9;

  private Node criaRibbon() {
    HBox ribbon = new HBox(5);
    ribbon.setPadding(new Insets(5));
    ribbon.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));

    item1 = new WRibbonItem("Botão", new Image("Paste_32.png"), WItemKind.BIG);
    item2 = new WRibbonItem("Botão", new Image("Paste_32.png"), WItemKind.MEDIUM);
    item3 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.SMALL);
    item4 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.SMALL);
    item5 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.SMALL);
    item6 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.SMALL);
    item7 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.ICON);
    item8 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.ICON);
    item9 = new WRibbonItem("Botão", new Image("Paste_16.png"), WItemKind.ICON);
    
    VBox column1 = new VBox(item1);
    VBox column2 = new VBox(5, item2, item3);
    VBox column3 = new VBox(5, item4, item5, item6);
    VBox column4 = new VBox(5, item7, item8, item9);
    
    ribbon.getChildren().addAll(column1, column2, column3, column4);
    return ribbon;
  }

  private Node criaPainelCentral() {
    Button botao1 = new Button("Troca texto do item1");
    botao1.setOnAction(event -> item1.setTexto("Texto trocado por um bem grande"));
    Button botao2 = new Button("Troca texto do item1");
    botao2.setOnAction(event -> item2.setTexto("Texto trocado por um bem grande"));
    Button botao3 = new Button("Troca texto do item1");
    botao3.setOnAction(event -> item3.setTexto("Texto trocado por um bem grande"));
    
    VBox tabRoot = new VBox(botao1, botao2, botao3);
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
