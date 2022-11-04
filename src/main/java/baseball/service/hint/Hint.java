package baseball.service.hint;

public class Hint {

  private int strikeCount;
  private int ballCount;

  public int getStrikeCount() {
    return strikeCount;
  }

  public int getBallCount() {
    return ballCount;
  }

  public Hint(int strikeCount, int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }
}
