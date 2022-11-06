package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ScoreCounter {

  int ballCount;
  int strikeCount;

  public void count(List<Integer> computerNumber, String input) {
    init();
    List<Integer> userInput = convertStringToIntegerList(input);
  }

  private List<Integer> convertStringToIntegerList(String input) {
    List<Integer> list = new ArrayList<>();
    String[] userInput = input.split("");
    for (String s : userInput) {
      list.add(Integer.parseInt(s));
    }
    return list;
  }

  private void init() {
    ballCount = 0;
    strikeCount = 0;
  }
}
