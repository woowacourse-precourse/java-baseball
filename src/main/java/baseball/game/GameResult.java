package baseball.game;

public class GameResult {

  private final Integer strike;
  private final Integer ball;

  public GameResult(Integer strike, Integer ball) {
    this.strike = strike;
    this.ball = ball;
  }

  public Integer getStrike() {
    return this.strike;
  }

  public Integer getBall() {
    return this.ball;
  }
}
