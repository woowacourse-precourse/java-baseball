package baseball;

import baseball.Utils.Validation;
import baseball.View.Constant;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class User {

  private int[] userNumber;

  public void inputNumber(String number) {
    String userInput = number;
    System.out.println(Constant.INPUT_MESSAGE);

    if (Validation.isValidInput(userInput)){
      setUserNumber(userInput);
    } else {
      throw new IllegalArgumentException(Constant.WRONG_INPUT);
    }


  }
  public int[] getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String number) {
    userNumber = new int[Constant.NUMBER_LENGTH];
    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      int eachNum = Character.getNumericValue(number.charAt(i));

      userNumber[i] = eachNum;
    }
  }
}
