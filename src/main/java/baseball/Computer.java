package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
  private BaseBallGameNumber gameNumber;

  public void setAnswerNumber() {
    gameNumber = new BaseBallGameNumber();
    List<Integer> numList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    gameNumber.setGameNumberByList(numList);
  }

  public BaseBallGameNumber getAnswerNumber() {
    return gameNumber;
  }
}
