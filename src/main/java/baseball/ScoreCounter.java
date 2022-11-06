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
    for (int i = 0; i < input.length(); i++) {
      if (isThereStrikes(computerNumber.get(i), userInput.get(i))) {
        strikeCount++;
        continue;
      }
      if (isThereBalls(computerNumber, userInput.get(i))) {
        ballCount++;
      }
    }
  }

  private boolean isThereStrikes(Integer computerNumber, Integer input) {
    return computerNumber.equals(input);
  }

  private boolean isThereBalls(List<Integer> computerNumbers, Integer input) {
    return computerNumbers.contains(input);
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
