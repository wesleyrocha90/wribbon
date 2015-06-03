package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.componet.WRichTooltip;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RichTooltipTest extends Application {

  private Node criaPainelCentral() {
    WRichTooltip tip = new WRichTooltip();
    tip.setTitulo("Folha de Rosto");
    tip.setImagemDescricao(new Image("Paste_32.png"));
    tip.addSecaoDescricao("Inserir uma folha de rosto completamente formatada");
    tip.addSecaoDescricao("Você preencherá o título, o autor, a data e outras informações");
    tip.setImagemRodape(new Image("Paste_16.png"));
    tip.addSecaoRodape("Pressione F1 para obter mais ajuda");
    
    StackPane tabRoot = new StackPane(tip);
    return new TabPane(new Tab("Cliente", tabRoot), new Tab("Vendas"));
  }

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane root = new BorderPane();
    root.setCenter(criaPainelCentral());

    Scene scene = new Scene(root, 400, 200);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
