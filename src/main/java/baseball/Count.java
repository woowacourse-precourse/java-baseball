package baseball;

import baseball.View.Constant;

public class Count {

  private int strike;
  private int ball;

  public void init() {
    this.strike = 0;
    this.ball = 0;
  }

  public void count(int[] answer, int[] userNumber) {
    init();

    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      countStrike(answer[i], userNumber[i]);
      countBall(answer, userNumber[i], i);
    }
  }

  public void countStrike(int computer, int user) {
    if (computer == user) {
      this.strike++;
    }
  }

  public void countBall(int[] answer, int user, int userIdx) {
    for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
      if (i != userIdx && answer[i] == user) {
        this.ball++;
      }
    }
  }

  public void print() {
    if (this.ball > 0) {
      System.out.print(this.ball + Constant.BALL);
    }
    if (this.strike > 0) {
      System.out.print(this.strike + Constant.STRIKE);
    }
    if (this.ball == 0 && this.strike == 0) {
      System.out.print(Constant.NOTHING);
    }
    System.out.println();
  }

  public int getStrike() {
    return this.strike;
  }
}
