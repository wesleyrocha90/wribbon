package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainTest extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World!");

    WButton button = new WButton("Clique!");
    WButton button2 = new WButton("Clique!");
    HBox root = new HBox(20);
    root.getChildren().addAll(button, button2);
    
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
