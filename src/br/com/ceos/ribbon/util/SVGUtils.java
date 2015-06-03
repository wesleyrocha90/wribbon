package br.com.ceos.ribbon.util;

import javafx.scene.shape.SVGPath;

/**
 *
 * @author Wesley
 * @since June 2nd 2015
 */
public class SVGUtils {
  
  public static SVGPath triangleUpsideDown(){
    SVGPath triangle = new SVGPath();
    triangle.setContent("M 0 0 L 3 3 L 6 0 Z");
    return triangle;
  }
}