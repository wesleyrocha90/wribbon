package br.com.ceos.ribbon.componet;

import impl.br.com.ceos.ribbon.skin.WRichTooltipSkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

/**
 * <p>O Tooltip é um componente usado para exibir informações extras sobre o funcionamento de outros componentes.
 * Normalmente seu funcionamento é ligado aos eventos do mouse, principalmente o hover.
 * <p>O WRichTooltip é um tooltip capaz de exibir diferentes tipos de informação, apresentadas utilizando 
 * o seguinte formato de exibição.
 * <pre>
 * +--------------------------------+
 * | Título                         |
 * | ********  Primeira linha da    |
 * | *Imagem*  seção de descrição   |
 * | ********                       |
 * |           Segunda linha da     |
 * |           seção de descrição   |
 * |--------------------------------|
 * | ********  Primeira linha da    |
 * | *Imagem*  seção de rodapé      |
 * | ********                       |
 * |           Segunda linha da     |
 * |           seção de rodapé      |
 * +--------------------------------+
 * </pre>
 * <p>O exemplo acima mostra um WRichTooltip contendo todos os tipos de informações possíveis, mas ele pode ser mais
 * simples, pode até não conter informação alguma, sendo apresentado como um retângulo vazio, mas isso é inútil.
 *
 * @author Wesley
 * @since 29 de Novembro de 2014
 */
public class WRichTooltip extends Control {

  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   ***************************************************************************/
  
  /**
   * Cria um tooltip vazio, sem nenhum elemento
   */
  public WRichTooltip() {
  }
  
  /**
   * Cria um tooltip com o título informado
   * @param titulo - O título do tooltip
   */
  public WRichTooltip(String titulo) {
    tituloProperty().set(titulo);
  }

  /**
   * Cria um tooltip com o título e com as seções de descrição informadas
   * @param titulo - O título do tooltip
   * @param secoesDescricao - Todos os textos que farão parte da descrição
   */
  public WRichTooltip(String titulo, String... secoesDescricao) {
    tituloProperty().set(titulo);
    secoesDescricaoProperty().addAll(secoesDescricao);
  }
  
  /***************************************************************************
   *                                                                         *
   * Properties                                                              *
   *                                                                         *
   ***************************************************************************/
    
  /**
   * O titulo deste tooltip, apresentado destacado
   */
  private StringProperty titulo;
  public final StringProperty tituloProperty() {
    return titulo != null ? titulo : (titulo = new SimpleStringProperty(this, "titulo"));
  }
  public final String getTitulo() {
    return tituloProperty().get();
  }
  public final void setTitulo(String titulo) {
    tituloProperty().set(titulo);
  }
    
  /**
   * A imagem apresentada como item da descrição
   */
  private ObjectProperty<Image> imagemDescricao;
  public final ObjectProperty<Image> imagemDescricaoProperty() {
    return imagemDescricao != null ? imagemDescricao 
        : (imagemDescricao = new SimpleObjectProperty<>(this, "imagemDescricao"));
  }
  public final Image getImagemDescricao() {
    return imagemDescricaoProperty().get();
  }
  public final void setImagemDescricao(Image imagemDescricao) {
    imagemDescricaoProperty().set(imagemDescricao);
  }
    
  /**
   * Todas as seções de texto que pertencem a descrição
   */
  private ObservableList<String> secoesDescricao;
  public final ObservableList<String> secoesDescricaoProperty() {
    return secoesDescricao != null ? secoesDescricao : (secoesDescricao = FXCollections.<String>observableArrayList());
  }
  public final ObservableList getSecoesDescricao() {
    return secoesDescricaoProperty();
  }
  public final void addSecaoDescricao(String secaoDescricao) {
    secoesDescricaoProperty().add(secaoDescricao);
  }

  /**
   * A imagem apresentada como item do rodapé
   */
  private ObjectProperty<Image> imagemRodape;
  public final ObjectProperty<Image> imagemRodapeProperty() {
    return imagemRodape != null ? imagemRodape : (imagemRodape = new SimpleObjectProperty<>(this, "imagemRodape"));
  }
  public final Image getImagemRodape() {
    return imagemRodapeProperty().get();
  }
  public final void setImagemRodape(Image imagemRodape) {
    imagemRodapeProperty().set(imagemRodape);
  }

  /**
   * Todas as seções de texto que pertencem ao rodapé
   */
  private ObservableList<String> secoesRodape;
  public final ObservableList<String> secoesRodapeProperty() {
    return secoesRodape != null ? secoesRodape : (secoesRodape = FXCollections.<String>observableArrayList());
  }
  public final ObservableList getSecoesRodape() {
    return secoesRodapeProperty();
  }
  public final void addSecaoRodape(String secaoRodape) {
    secoesRodapeProperty().add(secaoRodape);
  }
  
  /***************************************************************************
   *                                                                         *
   * Methods                                                                 *
   *                                                                         *
   **************************************************************************/
  
  /** {@inheritDoc} */
  @Override
  protected Skin<?> createDefaultSkin() {
    return new WRichTooltipSkin(this);
  }
  
  /***************************************************************************
   *                                                                         *
   * Stylesheet Handling                                                     *
   *                                                                         *
   ***************************************************************************/
}
