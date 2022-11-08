package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  private GameNumber gameNumber;

  public void setAnswerNumber() {
    gameNumber = new GameNumber();
    List<Integer> numList = new ArrayList<>();
    while (numList.size() < GameNumber.NUMBER_DIGIT) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!numList.contains(randomNumber)) {
        numList.add(randomNumber);
      }
    }
    gameNumber.setGameNumberByList(numList);
  }

  public GameNumber getAnswerNumber() {
    return gameNumber;
  }
}
