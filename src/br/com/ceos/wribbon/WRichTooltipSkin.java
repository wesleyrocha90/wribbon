package br.com.ceos.wribbon;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import java.util.Collections;
import java.util.function.Consumer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Wesley
 * @since 01 de Dezembro de 2014
 */
public class WRichTooltipSkin extends BehaviorSkinBase<WRichTooltip, BehaviorBase<WRichTooltip>> {
  
  //TODO tooltip não redimenciona para a altura necessária, checar
  private VBox container;

  public WRichTooltipSkin(WRichTooltip control) {
    super(control, new BehaviorBase<>(control, Collections.<KeyBinding>emptyList()));
    updateRichTooltip();
    getChildren().add(container);
  }

  private void updateRichTooltip() {
    container = new VBox();
    container.setFillWidth(true);
    container.setPadding(new Insets(10));
    container.setSpacing(5);
    container.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    container.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
    
    if(getSkinnable().hasDescriptionImage()){
      container.setPrefWidth(300);
      container.setMaxWidth(300);
      container.setMinWidth(300);
    }else if(getSkinnable().hasFooterSections()){
      container.setPrefWidth(240);
      container.setMaxWidth(240);
      container.setMinWidth(240);
    }else{
      container.setPrefWidth(180);
      container.setMaxWidth(180);
      container.setMinWidth(180);
    }
    
    updateTitle();
    updateDescriptionSections();
    if(getSkinnable().hasFooterSections()){
      container.getChildren().add(new Separator(Orientation.HORIZONTAL));
      updateFooterSections();
    }
  }
  
  private void updateTitle(){
    Label labelTitle = new Label(getSkinnable().getTitle());
    labelTitle.setFont(Font.font("System", FontWeight.BOLD, 12));
    container.getChildren().add(labelTitle);
  }
  
  private void updateDescriptionSections(){
    HBox descriptionPane = new HBox();
    descriptionPane.setSpacing(10);
    descriptionPane.setPrefHeight(0);
    
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
  }
  
  private void updateFooterSections(){
    HBox footerPane = new HBox();
    footerPane.setSpacing(10);
    
    ImageView footerImage = new ImageView(getSkinnable().getFooterImage());
    footerPane.getChildren().add(footerImage);
    
    VBox footerSectionsPanel = new VBox(10);
    ObservableList<String> footerSections = getSkinnable().getFooterSections();
    if (footerSections != null && footerSections.size() > 0) {
      footerSections.forEach((string) -> {
        Label label = new Label(string);
        label.setFont(Font.font("System", FontWeight.BOLD, 12));
        label.setTextFill(Color.BLUE);
        label.setWrapText(true);
        footerSectionsPanel.getChildren().add(label);
      });
      footerPane.getChildren().add(footerSectionsPanel);
    }
    
    container.getChildren().add(footerPane);
  }
}
