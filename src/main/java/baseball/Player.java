package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final List<Integer> numbers;

  public Player() {
    this.numbers = new ArrayList<>(3);
  }

  public void setNumbers(String input) {
    for (String number : input.split("")) {
      numbers.add(Integer.parseInt(number));
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

}
