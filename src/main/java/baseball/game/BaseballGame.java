package baseball.game;

import baseball.dto.GameInputNumber;
import java.util.List;

public class BaseballGame {

  private final List<Integer> computerNumbers;

  public BaseballGame(List<Integer> numbers) {
    this.computerNumbers = numbers;
  }


  public GameResult start(GameInputNumber gameInputNumber){
    /*
    *  TODO : strike, ball 카운트 메소드 구현.
    */
    return null;
  }
}
