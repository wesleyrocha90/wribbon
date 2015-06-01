package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WRibbonItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import br.com.ceos.ribbon.container.WRibbonBand;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BandTest extends Application {
  
  private Node criaRibbon() {
    HBox ribbon = new HBox(5);
    ribbon.setPadding(new Insets(5));
    ribbon.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
    WRibbonBand banda = new WRibbonBand("Principal", 
        new WRibbonItem("Botão 0", new Image("Paste_32.png"), WItemKind.BIG),
        new WRibbonItem("Botão 1", new Image("Paste_32.png"), WItemKind.MEDIUM),
        new WRibbonItem("Botão 2", new Image("Paste_16.png"), WItemKind.ICON), 
        new WRibbonItem("Botão 1", new Image("Paste_32.png"), WItemKind.SMALL),
        new WRibbonItem("Botão 0", new Image("Paste_32.png"), WItemKind.BIG),
        new WRibbonItem("Botão 2", new Image("Paste_16.png"), WItemKind.MEDIUM), 
        new WRibbonItem("Botão 1", new Image("Paste_32.png"), WItemKind.MEDIUM),
        new WRibbonItem("Botão 2", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 5", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 0", new Image("Paste_32.png"), WItemKind.BIG),
        new WRibbonItem("Botão 6", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 7", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 5", new Image("Paste_16.png"), WItemKind.ICON), 
        new WRibbonItem("Botão 6", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 7", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 0", new Image("Paste_32.png"), WItemKind.BIG),
        new WRibbonItem("Botão 5", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 6", new Image("Paste_16.png"), WItemKind.ICON), 
        new WRibbonItem("Botão 7", new Image("Paste_16.png"), WItemKind.SMALL), 
        new WRibbonItem("Botão 1", new Image("Paste_32.png"), WItemKind.ICON),
        new WRibbonItem("Botão 2", new Image("Paste_16.png"), WItemKind.MEDIUM));
    
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
