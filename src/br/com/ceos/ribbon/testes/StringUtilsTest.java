package br.com.ceos.ribbon.testes;

import br.com.ceos.ribbon.util.StringUtils;

public class StringUtilsTest {
  
  public static void main(String[] args) {
    String string = "Um texto para teste";
    
    String[] strings = StringUtils.splitInTwo(string);
    
    for (String s : strings) {
      System.out.println(s);
    }
  }
}
