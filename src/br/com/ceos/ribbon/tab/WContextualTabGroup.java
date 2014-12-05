package br.com.ceos.ribbon.tab;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 * Um grupo de {@link WTab}s. O grupo de tabs contextual permite exibir e 
 * esconder ribbon tabs baseados em certos tipos de contexto da aplicação.
 * 
 * @author Wesley
 * @since 05 de Dezembro de 2014
 */
public class WContextualTabGroup {
  
  private StringProperty titulo;
  private ObservableList<WTab> tabs;
  private ObjectProperty<Color> cor;
  private DoubleProperty transparencia = new SimpleDoubleProperty(this, "transparencia", .25);
  
}
