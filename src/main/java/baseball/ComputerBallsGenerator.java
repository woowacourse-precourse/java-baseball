package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallsGenerator {
  private int maxLen;
  private String balls;

  public ComputerBallsGenerator() {
    this(3);
  }
  public ComputerBallsGenerator(int maxLen) {
    this.maxLen = maxLen;
  }
  public void ballsGenerator(){
    String balls = Randoms.pickUniqueNumbersInRange(1, 9, this.maxLen).toString().replaceAll("[^0-9]","");
    this.balls = balls;
  }

  public int getBallsLength() {
    return balls.length();
  }
}
