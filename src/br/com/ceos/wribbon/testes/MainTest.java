package br.com.ceos.wribbon.testes;

import br.com.ceos.wribbon.WRichTooltip;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Wesley
 * @since 29 de Novembro de 2014
 */
public class MainTest extends Application{

  public static void main(String[] args) {
    Application.launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World!");
    
    WRichTooltip control = new WRichTooltip("Adcionar um Cabeçalho");
    control.setDescriptionImage(new Image("imagem.png"));
    control.addDescriptionSections("Os cabeçalhos o ajudam a repetir conteúdo na parte superior de cada página.");
    control.addDescriptionSections("Eles são úteis para apresentar informações, como título, autor e número de página");
    control.setFooterImage(new Image("question.png"));
    control.addFooterSections("Dê-me mais informações");
    
    StackPane root = new StackPane();
    root.getChildren().add(control);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}
