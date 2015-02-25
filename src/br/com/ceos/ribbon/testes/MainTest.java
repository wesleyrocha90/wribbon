package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WButton;
import br.com.ceos.ribbon.container.WBand;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainTest extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World!");

    WButton button1 = new WButton();
    WButton button2 = new WButton();
    WButton button3 = new WButton();
    WBand band = new WBand();
    band.getChildren().addAll(button1, button2, button3);
    
    AnchorPane root = new AnchorPane();
    root.getChildren().add(band);
    
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
