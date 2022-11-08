package baseball;

import java.util.List;

import static baseball.constants.Constant.*;
import static baseball.constants.Message.*;

public class Hint {

  private Integer strike;
  private Integer ball;

  private final Player player;
  private final Computer computer;

  public Hint(Player player, Computer computer) {
    this.player = player;
    this.computer = computer;
    this.strike = 0;
    this.ball = 0;
  }

  public Integer getUserNumber(int index) {
    return player.getEachNumber(index);
  }

  public Integer getAnswerNumber(int index) {
    return computer.getEachNumber(index);
  }

  public List<Integer> getAnswer() {
    return computer.getAnswer();
  }

  public boolean isStrike(int index) {
    return getUserNumber(index).equals(getAnswerNumber(index));
  }

  public boolean isBall(int index) {
    if (!isStrike(index)) {
      return getAnswer().contains(getUserNumber(index));
    }
    return false;
  }

  public void addStrike() {
    this.strike += 1;
  }

  public void addBall() {
    this.ball += 1;
  }

  public void countStrike(int index) {
    if (isStrike(index)) {
      addStrike();
    }
  }

  public void countBall(int index) {
    if (isBall(index)) {
      addBall();
    }
  }

  public String makeHint() {
    if (strike == 0 && ball == 0) {
      return "낫싱";
    }
    else if (strike != 0 && ball == 0){
      return strike + "스트라이크";
    }
    else if (strike == 0 && ball != 0){
      return ball + "볼";
    }
    else {
      return ball + "볼" + " " + strike + "스트라이크";
    }
  }

  public String getHint() {
    for (int i = 0; i < 3; i++) {
      countStrike(i);
      countBall(i);
    }
    return makeHint();
  }

}
