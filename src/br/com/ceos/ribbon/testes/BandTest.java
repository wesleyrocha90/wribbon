package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WRibbonItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import br.com.ceos.ribbon.container.WRibbonBand;
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

public class BandTest extends Application {
  
  private Node criaRibbon() {
    HBox ribbon = new HBox(5);
    ribbon.setPadding(new Insets(5));
    ribbon.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    
    WRibbonItem item0 = new WRibbonItem("Botão 0", new Image("Paste_32.png"), WItemKind.BIG);
    WRibbonItem item1 = new WRibbonItem("Botão 1", new Image("Paste_32.png"), WItemKind.BIG);
    WRibbonItem item2 = new WRibbonItem("Botão 2", new Image("Paste_32.png"), WItemKind.MEDIUM);
    WRibbonItem item3 = new WRibbonItem("Botão 3", new Image("Paste_16.png"), WItemKind.SMALL);
    WRibbonItem item4 = new WRibbonItem("Botão 4", new Image("Paste_16.png"), WItemKind.SMALL);
    WRibbonItem item5 = new WRibbonItem("Botão 5", new Image("Paste_16.png"), WItemKind.SMALL);
    WRibbonItem item6 = new WRibbonItem("Botão 6", new Image("Paste_16.png"), WItemKind.SMALL);
    WRibbonItem item7 = new WRibbonItem("Botão 7", new Image("Paste_16.png"), WItemKind.ICON);
    WRibbonItem item8 = new WRibbonItem("Botão 8", new Image("Paste_16.png"), WItemKind.ICON);
    WRibbonItem item9 = new WRibbonItem("Botão 9", new Image("Paste_16.png"), WItemKind.ICON);
    
    WRibbonBand banda = new WRibbonBand("Principal", 
        item0, item1, item2, item3, item4, item5, item6, item7, item8, item9);
    
    ribbon.getChildren().addAll(banda);
    return ribbon;
  }
  
  private Node criaPainelCentral() {
    return new TabPane(new Tab("Cliente"), new Tab("Vendas"));
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
