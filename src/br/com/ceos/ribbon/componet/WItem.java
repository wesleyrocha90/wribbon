package br.com.ceos.ribbon.componet;

import br.com.ceos.ribbon.componet.enumeration.WCommandKind;
import br.com.ceos.ribbon.componet.enumeration.WItemKind;
import impl.br.com.ceos.ribbon.skin.WItemBigSkin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Wesley
 * @since May 28th 2015
 */
public class WItem extends Control {

  /***************************************************************************
   * Constructors                                                            *
   ***************************************************************************/
  
  public WItem() {
  }

  public WItem(String text) {
    this(text, null, WItemKind.BIG);
  }

  public WItem(String text, Image icon) {
    this(text, icon, WItemKind.BIG);
  }

  public WItem(String text, Image icon, WItemKind kind) {
    setText(text);
    setIcon(icon);
    setTipo(kind);
    getStyleClass().add(DEFAULT_STYLE_CLASS);
  }

  /***************************************************************************
   * Properties                                                              *
   ***************************************************************************/
  
  /**
   * O texto do item
   */
  private StringProperty text;
  public StringProperty textProperty() {
    return text != null ? text : (text = new SimpleStringProperty(this, "text", ""));
  }
  public final String getText() { return text == null ? "" : text.get(); }
  public final void setText(String text) { textProperty().set(text); }

  /**
   * O ícone do item
   */
  private ObjectProperty<Image> icon;
  public ObjectProperty<Image> iconProperty() {
    return icon != null ? icon : (icon = new SimpleObjectProperty<>(this, "icon"));
  }
  public final Image getIcon() { return iconProperty().get(); }
  public final void setIcon(Image icon) { iconProperty().set(icon); }
  
  /**
   * O tipo de exibição do item
   */
  private ObjectProperty<WItemKind> kind = 
      new SimpleObjectProperty<>(this, "kind", WItemKind.BIG);
  public final ObjectProperty<WItemKind> tipoProperty() { return kind; }
  public final WItemKind getTipo() { return kind.get(); }
  public final void setTipo(WItemKind tipo) { this.kind.set(tipo); }
  
  /**
   * O tipo de comando do item
   */
  private ObjectProperty<WCommandKind> tipoComando = 
    new SimpleObjectProperty<>(this, "tipoComando", WCommandKind.ACAO_SOMENTE);
  public final ObjectProperty<WCommandKind> tipoComandoProperty() { return tipoComando; }
  public final WCommandKind getTipoComando() { return tipoComando.get(); }
  public final void setTipoComando(WCommandKind tipoComando) { this.tipoComando.set(tipoComando); }
  
  /**
   * A atalho exibido para acionar a ação do item
   */
  private StringProperty atalhoAcao = 
      new SimpleStringProperty(this, "atalhoAcao", "");
  public final StringProperty atalhoAcaoProperty() { return atalhoAcao; }
  public final String getAtalhoAcao() { return atalhoAcao.get(); }
  public final void setAtalhoAcao(String atalhoAcao) { this.atalhoAcao.set(atalhoAcao); }
  
  /**
   * A atalho exibido para acionar o popup do item
   */
  private StringProperty atalhoPopup = 
      new SimpleStringProperty(this, "atalhoPopup", "");
  public final StringProperty atalhoPopupProperty() { return atalhoPopup; }
  public final String getAtalhoPopup() { return atalhoPopup.get(); }
  public final void setAtalhoPopup(String atalhoPopup) { this.atalhoPopup.set(atalhoPopup); }
  
  /**
   * O {@link WRichTooltip tooltip} exibido para a ação do item
   */
  private ObjectProperty<WRichTooltip> tooltipAcao;
  public final ObjectProperty<WRichTooltip> tooltipAcaoProperty(){
    return tooltipAcao != null ? tooltipAcao : new SimpleObjectProperty<>(this, "tooltipAcao");
  }
  public final WRichTooltip getTooltipAcao() { return tooltipAcao == null ? null : tooltipAcao.get(); }
  public final void setTooltipAcao(WRichTooltip tooltipAcao) { tooltipAcaoProperty().set(tooltipAcao); }
  
  /**
   * O {@link WRichTooltip tooltip} exibido para o popup do item
   */
  private ObjectProperty<WRichTooltip> tooltipPopup;
  public final ObjectProperty<WRichTooltip> tooltipPopupProperty(){
    return tooltipPopup != null ? tooltipPopup : new SimpleObjectProperty<>(this, "tooltipPopup");
  }
  public final WRichTooltip getTooltipPopup() { return tooltipPopup == null ? null : tooltipPopup.get(); }
  public final void setTooltipPopup(WRichTooltip tooltipPopup) { tooltipPopupProperty().set(tooltipPopup); }
  
  /**
   * A ação que será executada quando o item for pressionado
   */
  private ObjectProperty<EventHandler<ActionEvent>> onAction = 
    new ObjectPropertyBase<EventHandler<ActionEvent>>() {
      @Override protected void invalidated() {
        setEventHandler(ActionEvent.ACTION, get());
      }
      @Override public Object getBean() { return WItem.this; }
      @Override public String getName() { return "onAction"; }
  };
  public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() { return onAction; }
  public final EventHandler<ActionEvent> getOnAction() { return onAction.get(); }
  public final void setOnAction(EventHandler<ActionEvent> onAction) { this.onAction.set(onAction); }
  
  /***************************************************************************
   * Methods                                                                 *
   **************************************************************************/
  
  /** {@inheritDoc} */
  @Override
  protected Skin<?> createDefaultSkin() {
//    switch(getTipo()){
//      case BIG:
//        return new WItemBigSkin(this);
//      case MEDIUM:
//        return new WItemMediumSkin(this);
//      case SMALL:
//        return new WItemSmallSkin(this);
//      case ICON:
//        return new WItemIconSkin(this);
//    }
    return new WItemBigSkin(this);
  }

  /***************************************************************************
   * Stylesheet Handling                                                     *
   ***************************************************************************/
  
  private static class StyleableProperties {    
    private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
    static{
      final List<CssMetaData<? extends Styleable, ?>> styleables =
          new ArrayList<>(Control.getClassCssMetaData());
      STYLEABLES = Collections.unmodifiableList(styleables);
    }
  }
  
  public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
    return StyleableProperties.STYLEABLES;
  }
  
  private static final String DEFAULT_STYLE_CLASS = "w-item";
}
