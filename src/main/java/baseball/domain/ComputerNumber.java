package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
  private final List<Integer> computerNumber;
  private final int MAX_NUMBER_SIZE = 3;
  private final int MINIMUM_NUMBER = 1;
  private final int MAXIMUM_NUMBER = 9;

  public ComputerNumber() {
    computerNumber = new ArrayList<>();
  }

  public void setComputerNumber() {
    while (computerNumber.size() < MAX_NUMBER_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
      if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber);
      }
    }
  }

  public List<Integer> getComputerNumber() {
    return computerNumber;
  }
}
