package baseball;

import static error.RandomError.isDuplicateNumber;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

  private int num = 0;

  public RandomNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {
    int random;

    for (int i = 0; i < 3; i++) {
      num *= 10;
      random = pickNumberInRange(1, 9);
      if (isDuplicateNumber(random, num, i + 1)) {
        i--;
        continue;
      }
      num += random;
    }
  }

  public int getRandomNumber() {
    return num;
  }

}
