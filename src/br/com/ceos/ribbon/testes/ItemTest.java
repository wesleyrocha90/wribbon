package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.componet.enumeration.WCommandKind;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class ItemTest extends Application {

  private WItem item1, item2;

  private Node criaRibbon() {
    FlowPane ribbon = new FlowPane();
    ribbon.setOrientation(Orientation.VERTICAL);
    ribbon.setMaxHeight(85);
    ribbon.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

    item1 = new WItem("Colar Especial", new Image("Paste_32.png"), WItemKind.BIG);
    item1.setTipoComando(WCommandKind.ACAO_SOMENTE);
    item1.setOnAction(event -> System.out.println("Item1 clicado"));
    
    item2 = new WItem("Recortar", new Image("Paste_32.png"), WItemKind.BIG);
    item2.setTipoComando(WCommandKind.ACAO_E_POPUP_PRINCIPAL_ACAO);
    item2.setOnAction(event -> System.out.println("Item2 clicado"));
    
    ribbon.getChildren().addAll(item1, item2);
    return ribbon;
  }

  private Node criaPainelCentral() {
    Label label1 = new Label("Mudar texto botão1");
    TextField field1 = new TextField();
    Button button1 = new Button("Troca");
    button1.setOnAction(event -> item1.setTexto(field1.getText()));
    HBox mudanca1 = new HBox(label1, field1, button1);
    
    VBox tabRoot = new VBox(mudanca1);
    return new TabPane(new Tab("Teste de mudanças de propriedades", tabRoot));
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