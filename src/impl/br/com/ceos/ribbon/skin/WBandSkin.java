package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import br.com.ceos.ribbon.container.WBand;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Wesley
 * @since May 30th 2015
 */
public class WBandSkin extends SkinBase<WBand>{
  
  private VBox container;
  private HBox itensContainer;
  private StackPane textoContainer;
  private Text texto;
  
  public WBandSkin(WBand control) {
    super(control);
    updateItem();
  }
  
  private void updateItem() { 
    if (container != null) {
      getChildren().remove(container);
    }
    updateItensContainer();
    updateTextoContainer();

    container = new VBox(itensContainer, textoContainer);
    container.setPadding(new Insets(5));
    container.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    container.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
    
    getChildren().add(container);
  }
  
  private void updateItensContainer(){
    itensContainer = new HBox();
    itensContainer.setSpacing(5);
    
    ObservableList<WItem> itens = getSkinnable().getItens();
    layoutColumns(itensContainer, itens);
  }
  
  private void updateTextoContainer(){
    texto = new Text();
    texto.textProperty().bind(getSkinnable().textoProperty());
    
    textoContainer = new StackPane(texto);
    textoContainer.setAlignment(Pos.TOP_CENTER);
  }
  
  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateItem();
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
  
  private void layoutColumns(HBox container, ObservableList<WItem> itens){
    int pesoMaximo = 3;
    int pesoAcumulado = 0;
    
    VBox coluna = new VBox();
    for (WItem item : itens) {
      if(pesoAcumulado + item.getTipo().getPeso() <= pesoMaximo){
        coluna.getChildren().add(item);
        
        pesoAcumulado += item.getTipo().getPeso();
      }else{
        container.getChildren().add(coluna);
        coluna = new VBox();
        coluna.getChildren().add(item);
        
        pesoAcumulado = 0;
        pesoAcumulado += item.getTipo().getPeso();
      }
    }
    container.getChildren().add(coluna);
  }
}
