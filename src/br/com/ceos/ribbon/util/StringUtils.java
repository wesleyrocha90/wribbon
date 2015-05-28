package br.com.ceos.ribbon.util;

public class StringUtils {
  
  public static String[] splitInTwo(String string){
    String[] strings = string.split(" ");
    String one = "";
    String two = "";
    if(strings.length > 1){
      for(int i = 0; i < strings.length / 2; i++){
        one += strings[i].trim() + " ";
      }
      for(int i = strings.length / 2; i < strings.length; i++){
        two += strings[i].trim() + " ";
      }
    }else{
      one = strings[0];
    }
    return new String[]{one.trim(), two.trim()};
  }
}
