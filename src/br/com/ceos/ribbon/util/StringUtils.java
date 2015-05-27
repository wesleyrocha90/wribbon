package br.com.ceos.ribbon.util;

public class StringUtils {
  
  public static String[] splitInTwo(String string){
    String[] strings = string.split(" ");
    String one = "";
    String two = "";
    for(int i = 0; i < strings.length / 2; i++){
      one += strings[i] + " ";
    }
    for(int i = strings.length / 2; i < strings.length; i++){
      two += strings[i] + " ";
    }
    return new String[]{one.trim(), two.trim()};
  }
}
