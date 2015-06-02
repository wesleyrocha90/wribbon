package impl.br.com.ceos.ribbon.skin;

import br.com.ceos.ribbon.WRibbon;
import br.com.ceos.ribbon.componet.WItem;
import br.com.ceos.ribbon.container.WTab;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
 * @since June 1st 2015
 */
public class WRibbonSkin extends SkinBase<WRibbon> {

  private TabPane container;

  public WRibbonSkin(WRibbon control) {
    super(control);
    updateItem();
  }

  private void updateItem() {
    if (container != null) {
      getChildren().remove(container);
    }

    container = new TabPane(updateTabsContainer());
    container.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

    getChildren().add(container);
  }

  private Tab[] updateTabsContainer() {
    Tab[] tabs = new Tab[getSkinnable().getTabs().size()];
    for (int i = 0; i < getSkinnable().getTabs().size(); i++) {
      HBox bandContainer = new HBox();
      bandContainer.setSpacing(5);
      bandContainer.setPadding(new Insets(5));
      bandContainer.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
      bandContainer.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
      
      bandContainer.getChildren().addAll(getSkinnable().getTabs().get(i).getBandas());
      Tab tab = new Tab(getSkinnable().getTabs().get(i).getTexto());
      tab.setContent(bandContainer);
      tabs[i] = tab;
    }
    return tabs;
  }

  @Override
  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
    updateItem();
    layoutInArea(container, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
  }
}
