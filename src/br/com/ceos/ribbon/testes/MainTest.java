package br.com.ceos.ribbon.testes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Wesley
 * @since 29 de Novembro de 2014
 */
public class MainTest extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World!");

    // TODO testar se alteração de css funciona em tempo real
    Button button = new Button("Teste WRichTooltip");
    button.getStyleClass().add("commandButton");
    
    Button troca = new Button("Troca Estilo");
    troca.setOnAction(event -> {
      button.getStyleClass().clear();
      button.getStyleClass().add("commandButtonBig");
    });

    VBox root = new VBox(20);
    root.setFillWidth(true);
    root.setAlignment(Pos.TOP_CENTER);
    root.getChildren().add(button);
    root.getChildren().add(troca);
    
    Scene scene = new Scene(root);
    scene.getStylesheets().add("estilo.css");
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
