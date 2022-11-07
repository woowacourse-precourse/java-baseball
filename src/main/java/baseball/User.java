package baseball;

import baseball.Utils.Validation;
import baseball.View.Constant;
import java.util.ArrayList;

public class User {

  private ArrayList<Integer> userNumber;

  public void inputNumber(String number) {
    String userInput = number;
    System.out.println(Constant.INPUT_MESSAGE);

    if (Validation.isValidInput(userInput)){
      setUserNumber(userInput);
    } else {
      throw new IllegalArgumentException(Constant.WRONG_INPUT);
    }


  }
  public ArrayList<Integer> getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String number) {
    userNumber = new ArrayList<>();

    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      int eachNum = Character.getNumericValue(number.charAt(i));
      userNumber.add(eachNum);
    }
  }
}
