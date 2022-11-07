package baseball.game;

import baseball.dto.GameInputNumber;
import java.util.List;

public class BaseballGame {

  private final List<Integer> computerNumbers;

  public BaseballGame(List<Integer> numbers) {
    this.computerNumbers = numbers;
  }


  public GameResult start(GameInputNumber gameInputNumber) {

    List<Integer> userNumbers = gameInputNumber.getNumbers();
    int strikeCount = countStrike(userNumbers);
    int ballCount = countBall(userNumbers, strikeCount);
    return new GameResult(strikeCount, ballCount);
  }

  private int countStrike(List<Integer> userNumbers) {
    int count = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(userNumbers.get(i))) {
        count++;
      }
    }
    return count;
  }

  private int countBall(List<Integer> userNumbers, int strikeNumber) {
    int count = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      int userNumber = userNumbers.get(i);
      if (computerNumbers.contains(userNumber)) {
        count++;
      }
    }
    return count - strikeNumber;
  }
}
