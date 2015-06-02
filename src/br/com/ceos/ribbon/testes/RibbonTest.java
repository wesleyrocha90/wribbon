package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.WRibbon;
import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import br.com.ceos.ribbon.container.WBand;
import br.com.ceos.ribbon.container.WTab;
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

public class RibbonTest extends Application {
  
  private Node criaRibbon() {
    WRibbon ribbon = 
      new WRibbon(
        new WTab("PÁGINA INICIAL", 
          new WBand("Área de Transferência", 
            new WItem("Colar", new Image("Paste_32.png"), WItemKind.BIG),
            new WItem("Recortar", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Copiar", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Pincel de Formatação", new Image("Paste_32.png"), WItemKind.SMALL)),
          new WBand("Edição", 
            new WItem("Localizar", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Substituir", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Selecionar", new Image("Paste_32.png"), WItemKind.SMALL))),
        new WTab("INSERIR", 
          new WBand("Páginas", 
            new WItem("Folha de Rosto", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Página em Branco", new Image("Paste_32.png"), WItemKind.SMALL),
            new WItem("Quebra de Página", new Image("Paste_32.png"), WItemKind.SMALL)),
          new WBand("Tabelas", 
            new WItem("Tabela", new Image("Paste_32.png"), WItemKind.BIG)))
    );
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