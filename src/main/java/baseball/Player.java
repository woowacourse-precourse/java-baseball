package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.Constant.*;

public class Player {

  private final List<Integer> numbers;
  private final Validator validator;

  public Player() {
    this.numbers = new ArrayList<>(NUMBER_LENGTH);
    this.validator = new Validator();
  }

  public void setNumbers(String input) {
    for (String number : input.split("")) {
      numbers.add(Integer.parseInt(number));
    }
    validator.validate(numbers);
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public Integer getEachNumber(int index) {
    return numbers.get(index);
  }


}
