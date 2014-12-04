package br.com.ceos.wribbon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

/**
 * <p>
 * Componente usado para exibir informações adcionais sobre outro componente específico do Ribbon.
 * <p>
 * O WRichTooltip é capaz de exibir diferentes tipos de informação utilizando o seguinte formato de
 * exibição
 * <pre>
 * +--------------------------------+
 * | Título                         |
 * | ********  Primeira linha da    |
 * | *imagem*  seção de descrição   |
 * | ********                       |
 * |           Segunda linha da     |
 * |           seção de descrição   |
 * |--------------------------------|
 * | ********  Primeira linha da    |
 * | *imagem*  seção de rodapé      |
 * | ********                       |
 * |           Segunda linha da     |
 * |           seção de rodapé      |
 * +--------------------------------+
 * </pre>
 *
 * @author Wesley
 * @since 29 de Novembro de 2014
 */
public class WRichTooltip extends Control {

  private StringProperty titulo;
  private ObjectProperty<Image> imagemDescricao;
  private ObservableList<String> secoesDescricao;
  private ObjectProperty<Image> imagemRodape;
  private ObservableList<String> secoesRodape;

  private BooleanProperty temTitulo = new SimpleBooleanProperty(this, "temTitulo", false);
  private BooleanProperty temDescricao = new SimpleBooleanProperty(this, "temDescricao", false);
  private BooleanProperty temRodape = new SimpleBooleanProperty(this, "temRodape", false);

  public WRichTooltip() {

  }

  public WRichTooltip(String titulo) {
    tituloProperty().set(titulo);
  }

  public WRichTooltip(String titulo, String... secoesDescricao) {
    tituloProperty().set(titulo);
    secoesDescricaoProperty().addAll(secoesDescricao);
  }

  public final StringProperty tituloProperty() {
    if (titulo == null) {
      titulo = new SimpleStringProperty(this, "titulo", "");
    }
    return titulo;
  }

  public final String getTitulo() {
    return tituloProperty().get();
  }

  public final void setTitulo(String titulo) {
    tituloProperty().set(titulo);
  }

  public final ObjectProperty<Image> imagemDescricaoProperty() {
    if (imagemDescricao == null) {
      imagemDescricao = new SimpleObjectProperty<>();
    }
    return imagemDescricao;
  }

  public final Image getImagemDescricao() {
    return imagemDescricaoProperty().get();
  }

  public final void setImagemDescricao(Image imagemDescricao) {
    temDescricao.set(true);
    imagemDescricaoProperty().set(imagemDescricao);
  }

  public final ObservableList<String> secoesDescricaoProperty() {
    if (secoesDescricao == null) {
      secoesDescricao = FXCollections.<String>observableArrayList();
    }
    return secoesDescricao;
  }

  public final ObservableList getSecoesDescricao() {
    return secoesDescricao;
  }

  public final void addSecaoDescricao(String secaoDescricao) {
    secoesDescricaoProperty().add(secaoDescricao);
  }

  public final ObjectProperty<Image> imagemRodapeProperty() {
    if (imagemRodape == null) {
      imagemRodape = new SimpleObjectProperty<>();
    }
    return imagemRodape;
  }

  public final Image getImagemRodape() {
    return imagemRodapeProperty().get();
  }

  public final void setImagemRodape(Image imagemRodape) {
    temRodape.set(true);
    imagemRodapeProperty().set(imagemRodape);
  }

  public final ObservableList<String> secoesRodapeProperty() {
    if (secoesRodape == null) {
      secoesRodape = FXCollections.<String>observableArrayList();
    }
    return secoesRodape;
  }

  public final ObservableList getSecoesRodape() {
    return secoesRodape;
  }

  public final void addSecaoRodape(String secaoRodape) {
    temRodape.set(true);
    secoesRodapeProperty().add(secaoRodape);
  }

  public final boolean temImagemDescricao() {
    return temDescricao.get();
  }

  public final boolean temRodape() {
    return temRodape.get();
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new WRichTooltipSkin(this);
  }
}
