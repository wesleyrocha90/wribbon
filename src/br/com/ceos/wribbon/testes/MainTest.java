package br.com.ceos.wribbon.testes;

import br.com.ceos.wribbon.WRichTooltip;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
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

    //TODO extrair comportamento do tooltip para outro lugar
    Popup p = new Popup();
    WRichTooltip tip = new WRichTooltip();
    tip.setTitulo("Adcionar um Cabeçalho");
    tip.setImagemDescricao(new Image("imagem.png"));
    tip.addSecaoDescricao("Os cabeçalhos o ajudam a repetir conteúdo na parte superior de cada página.");
    tip.addSecaoDescricao("Eles são úteis para apresentar informações, como título, autor e número de página.");
    tip.setImagemRodape(new Image("question.png"));
    tip.addSecaoRodape("Dê-me mais informações");
    p.getContent().add(tip);
    
    Button button = new Button("Teste WRichTooltip");
    button.setOnMouseEntered(event -> p.show(button, button.getLayoutX(), button.getLayoutY() + button.getHeight() + 30));
    button.setOnMouseExited(event -> p.hide());

    VBox root = new VBox();
    root.setFillWidth(true);
    root.setAlignment(Pos.TOP_CENTER);
    root.getChildren().add(button);
    primaryStage.setScene(new Scene(root));
    primaryStage.setMaximized(true);
    primaryStage.show();
  }
}
