package baseball.domain;

import static baseball.util.setting.BallSetting.*;

public class Hint{
  private int strike = 0;
  private int ball = 0;

  public void countStrikeAndBall(Balls userNumbers, Balls computerNumbers){
    for(int i=0; i<BALL_SIZE.getBallSetting(); i++){
      strike += countStrike(userNumbers,computerNumbers,i);
      ball += countBall(userNumbers, computerNumbers, i);
    }
  }
  private int countStrike(Balls userNumbers, Balls computerNumbers, int index){
    int userNumber = userNumbers.getBalls().get(index);
    int computerNumber = computerNumbers.getBalls().get(index);
    if (userNumber==computerNumber){
      return 1;
    }
    return 0;
  }

  private int countBall(Balls userNumbers, Balls computerNumbers, int index){
    int userNumber = userNumbers.getBalls().get(index);
    int computerNumber = computerNumbers.getBalls().get(index);
    if (computerNumbers.getBalls().contains(userNumber)
        && !(userNumber==computerNumber)){
      return 1;
    }
    return 0;
  }

  public int getStrike(){
    return strike;
  }

  @Override
  public String toString() {
    if (ball!= 0 && strike!= 0) {
      return ball + "볼" + " " + strike + "스트라이크";
    }
    if (ball != 0) {
      return ball + "볼";
    }
    if (strike != 0) {
      return strike + "스트라이크";
    }
    return "낫싱";
  }

}
