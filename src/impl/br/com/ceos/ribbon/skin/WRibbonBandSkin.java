package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.componet.WRibbonItem;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import br.com.ceos.ribbon.container.WRibbonBand;
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
public class WRibbonBandSkin extends SkinBase<WRibbonBand>{
  
  private VBox container;
  private HBox itensContainer;
  private StackPane textoContainer;
  private Text texto;
  
  public WRibbonBandSkin(WRibbonBand control) {
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
    getChildren().add(container);
  }
  
  private void updateItensContainer(){
    itensContainer = new HBox();
    itensContainer.setSpacing(5);
    
    ObservableList<WRibbonItem> itens = getSkinnable().getItens();
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
  
  private void layoutColumns(HBox container, ObservableList<WRibbonItem> itens){
    int pesoMaximo = 3;
    int pesoAcumulado = 0;
    
    VBox coluna = new VBox(5);
    for (WRibbonItem item : itens) {
      if(pesoAcumulado + item.getTipo().getPeso() <= pesoMaximo){
        coluna.getChildren().add(item);
        
        pesoAcumulado += item.getTipo().getPeso();
      }else{
        container.getChildren().add(coluna);
        coluna = new VBox(5);
        coluna.getChildren().add(item);
        
        pesoAcumulado = 0;
        pesoAcumulado += item.getTipo().getPeso();
      }
    }
    container.getChildren().add(coluna);
  }
}
