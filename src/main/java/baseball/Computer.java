package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  private GameNumber gameNumber;

  public void setAnswerNumber() {
    gameNumber = new GameNumber();
    List<Integer> randomNumberList = createRandomNumberList();
    gameNumber.setGameNumberByList(randomNumberList);
  }

  private List<Integer> createRandomNumberList(){
    List<Integer> numList = new ArrayList<>();
    while (numList.size() < GameNumber.NUMBER_DIGIT) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      boolean isUniqueNumber = !numList.contains(randomNumber);
      if (isUniqueNumber) numList.add(randomNumber);
    }
    return numList;
  }

  public GameNumber getAnswerNumber() {
    return gameNumber;
  }
}
