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

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Ribbon!");
    
    WButton button1 = new WButton("Colar");
    
    HBox ribbon = new HBox(button1);
    ribbon.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
    
    BorderPane root = new BorderPane(new AnchorPane());
    root.setTop(ribbon);
    Scene scene = new Scene(root, 400, 400);
    stage.setScene(scene);
    stage.show();
  }
  
  public static void main(String[] args) {
    Application.launch(args);
  }
}
