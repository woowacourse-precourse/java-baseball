package baseball.Utils;

import baseball.Computer;
import baseball.View.Constant;

public class Validation {

  public static boolean isValidInput(String number) {
    return isNumber(number) && isRightLength(number) && isNotDuplicate(number);
  }

  public static boolean isNumber(String number) {
    for (int i = 0; i < number.length(); i++) {
      char eachNum = number.charAt(i);

      if (!Character.isDigit(eachNum)){
        return false;
      }
    }
    return true;
  }

  public static boolean isRightLength(String number) {
    return number.length() == Constant.NUMBER_LENGTH;
  }

  public static boolean isNotDuplicate(String number) {
    boolean[] alreadyUse = new boolean[Constant.MAX_VALUE + 1];

    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      int eachDigit = Character.getNumericValue(number.charAt(i));

      if(!alreadyUse[eachDigit]) {
        alreadyUse[eachDigit] = true;
      } else {
        return false;
      }
    }
    return true;
  }

  private static boolean isRightRange(String number){
    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      int eachDigit = Character.getNumericValue(number.charAt(i));

      if (eachDigit < Constant.MIN_VALUE || eachDigit > Constant.MAX_VALUE) {
        return false;
      }
    }
    return true;
  }
}
