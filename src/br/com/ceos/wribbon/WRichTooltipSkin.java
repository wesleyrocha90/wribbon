package br.com.ceos.wribbon;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import java.util.Collections;
import java.util.function.Consumer;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

/**
 *
 * @author Wesley
 * @since 01 de Dezembro de 2014
 */
public class WRichTooltipSkin extends BehaviorSkinBase<WRichTooltip, BehaviorBase<WRichTooltip>> {

  private VBox container;

  public WRichTooltipSkin(WRichTooltip control) {
    super(control, new BehaviorBase<>(control, Collections.<KeyBinding>emptyList()));
    updateRichTooltip();
    getChildren().add(container);
  }

  public void updateRichTooltip() {
    container = new VBox();
    
    Label labelTitle = new Label(getSkinnable().getTitle());
    container.getChildren().add(labelTitle);
    
    HBox descriptionPane = new HBox();
    
    ImageView descriptionImage = new ImageView(getSkinnable().getDescriptionImage());
    descriptionPane.getChildren().add(descriptionImage);

    VBox descriptionSectionsPanel = new VBox(10);
    ObservableList<String> descriptionSections = getSkinnable().getDescriptionSections();
    if (descriptionSections != null && descriptionSections.size() > 0) {
      descriptionSections.forEach((string) -> {
        Label label = new Label(string);
        label.setWrapText(true);
        descriptionSectionsPanel.getChildren().add(label);
      });
    }
    descriptionPane.getChildren().add(descriptionSectionsPanel);
    
    container.getChildren().add(descriptionPane);
    
    container.getChildren().add(new Line());
    
    HBox footerPane = new HBox();
    
    ImageView footerImage = new ImageView(getSkinnable().getFooterImage());
    footerPane.getChildren().add(footerImage);
    
    VBox footerSectionsPanel = new VBox(10);
    ObservableList<String> footerSections = getSkinnable().getFooterSections();
    if (footerSections != null && footerSections.size() > 0) {
      footerSections.forEach((string) -> footerSectionsPanel.getChildren().add(new Label(string)));
      footerPane.getChildren().add(footerSectionsPanel);
    }
    
    container.getChildren().add(footerPane);
  }
}
