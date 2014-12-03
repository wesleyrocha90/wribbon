package br.com.ceos.wribbon.testes;

import br.com.ceos.wribbon.WRichTooltip;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
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
    
    //TODO extrair comportamento do tooltip para outro lugar
    Popup p = new Popup();
    WRichTooltip tip = new WRichTooltip("Adcionar um Cabeçalho");
//    tip.setDescriptionImage(new Image("imagem.png"));
    tip.addDescriptionSections("Os cabeçalhos o ajudam a repetir conteúdo na parte superior de cada página.");
//    tip.addDescriptionSections("Eles são úteis para apresentar informações, como título, autor e número de página");
//    tip.addDescriptionSections("Os cabeçalhos o ajudam a repetir conteúdo na parte superior de cada página.");
//    tip.addDescriptionSections("Eles são úteis para apresentar informações, como título, autor e número de página");
//    tip.setFooterImage(new Image("question.png"));
//    tip.addFooterSections("Dê-me mais informações");
//    tip.addFooterSections("Dê-me mais informações");
    p.getContent().add(tip);
    p.sizeToScene();
    
    Button button = new Button("Teste WRichTooltip");
    button.setOnMouseEntered(event -> {
      p.show(button, button.getLayoutX(), button.getLayoutY() + button.getHeight() + 30);
    });
    button.setOnMouseExited(event -> {
      p.hide();
    });
    
    VBox root = new VBox();
    root.setFillWidth(true);
    root.setAlignment(Pos.TOP_CENTER);
    root.getChildren().add(button);
    primaryStage.setScene(new Scene(root));
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
