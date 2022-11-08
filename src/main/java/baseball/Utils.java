package baseball;

import java.util.Arrays;

public class Utils {

  /**
   * Verify string contains characters that have been used once.
   * @param string the string to be checked.
   * @return true if no duplicate value exists.
   */
  public static boolean isDistinct(String string) {
    String[] strArr = string.split("");
    return Arrays.stream(strArr)
        .distinct()
        .count() == strArr.length;
  }

  /**
   * Verify string is numeric.
   * @param string the string to be checked.
   * @return true if string is numeric.
   */
  public static boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }

  /**
   * Verify string contains zero.
   * @param string the string to be checked.
   * @return true if zero exists.
   */
  public static boolean isContainZero(String string) {
    String[] strArr = string.split("");
    return Arrays.asList(strArr).contains("0");
  }
}
