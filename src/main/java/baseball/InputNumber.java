package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

  public static String PleaseInput() {
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public static List<Integer> InputNumber(String userInput) {
    List<Integer> listInputNumber = new ArrayList<>();
    for (int i = 0; i < userInput.length(); i++) {
      char singleCh = userInput.charAt(i);

      int numericValue = Character.getNumericValue(singleCh);
      listInputNumber.add(numericValue);
    }

    return listInputNumber;
  }

  public static boolean checkUserInput(String userInput) {
    return userInput.matches("\\d\\d\\d");
  }

}
