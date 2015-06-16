package br.com.ceos.ribbon.util;

public class StringUtils {
  
  public static boolean isEmpty(final CharSequence cs){
    return cs == null || cs.length() == 0;
  }
  
  public static String[] splitInTwo(String string) {
    String[] strings = string.split(" ");
    String one = "";
    String two = "";
    if (strings.length == 1) {
      one = strings[0];
    } else if (strings.length == 2) {
      one = strings[0];
      two = strings[1];
    } else /*if(strings.length > 2)*/ {
      for (int i = 0; i < (strings.length / 2) + 1; i++) {
        one += strings[i].trim() + " ";
      }
      for (int i = (strings.length / 2) + 1; i < strings.length; i++) {
        two += strings[i].trim() + " ";
      }
    }
    return new String[]{one.trim(), two.trim()};
  }
}
