package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WButton;
import br.com.ceos.ribbon.container.WBand;
import br.com.ceos.ribbon.container.WBandPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainTest extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Ribbon!");
    
    WButton button1 = new WButton("Colar", new Image("Paste_128.png"));
    WButton button2 = new WButton("Copiar", new Image("Copy_128.png"));
    WButton button3 = new WButton("Testando um texto grande", new Image("Copy_128.png"));
//    WBand band = new WBand("Titulo", null);
//    band.addButtons(button1, button2, button3);
//    WBandPane band = new WBandPane();
//    band.getChildren().addAll(button1, button2, button3);
    
    
    HBox root = new HBox(button1, button2, button3);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
