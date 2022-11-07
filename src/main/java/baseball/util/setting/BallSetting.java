package baseball.util.setting;

public enum BallSetting {
  BALL_MIN_NUMBER(1),
  BALL_MAX_NUMBER(9),
  BALL_SIZE(3);

  private final int ballSetting;

  BallSetting(int ballSetting) {
    this.ballSetting = ballSetting;
  }

  public int getBallSetting() {
    return ballSetting;
  }
}
