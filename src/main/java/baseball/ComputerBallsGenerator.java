package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallsGenerator {
  private int maxLen;

  public ComputerBallsGenerator() {
    this(3);
  }
  public ComputerBallsGenerator(int maxLen) {
    this.maxLen = maxLen;
  }
  public String ballsGenerator(){
    return Randoms.pickUniqueNumbersInRange(1, 9, this.maxLen).toString().replaceAll("[^0-9]","");
  }
}
