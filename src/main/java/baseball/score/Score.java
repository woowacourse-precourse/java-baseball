package baseball.score;

import java.util.List;
import java.util.stream.IntStream;

public class Score {
  private Integer strikeCount;
  private Integer ballCount;

  private Score(){
    this.strikeCount = 0;
    this.ballCount = 0;
  }

  public void compareTwoNumber(List<Integer> computer, List<Integer> user) {
    setStrikeCount(computer, user);
    setBallCount(computer, user);
  }
}
