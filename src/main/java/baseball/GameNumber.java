package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
  public static final int NUMBER_DIGIT = 3;
  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    List<Integer> numbers = new ArrayList<>();
    for (char s : inputString.toCharArray()) numbers.add(GameNumberValidator.checkIsInt(s));
    setGameNumberByList(numbers);
  }

  public void setGameNumberByList(List<Integer> numberList) {
    for (int i : numberList) gameNumberList.add(i);
    GameNumberValidator.checkNumbersValid(gameNumberList);
  }



  public List<Integer> getGameNumberList() {
    return this.gameNumberList;
  }
}
