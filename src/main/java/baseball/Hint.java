package baseball;

import java.util.List;

import static baseball.constants.Constant.*;

public class Hint {
  private Integer strike;
  private Integer ball;

  private List<Integer> userNumbers;
  private List<Integer> answer;

  public Hint(List<Integer> userNumbers, List<Integer> answer) {
    this.userNumbers = userNumbers;
    this.answer = answer;
    this.strike = 0;
    this.ball = 0;
  }

  public boolean isStrike(int index) {
    return userNumbers.get(index).equals(answer.get(index));
  }

  public boolean isBall(int index) {
    if (!isStrike(index)) {
      return answer.contains(userNumbers.get(index));
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
    for (int i = 0; i < NUMBER_LENGTH; i++) {
      countStrike(i);
      countBall(i);
    }
    return makeHint();
  }

}
