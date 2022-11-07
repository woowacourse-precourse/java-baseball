package baseball.domain;

import static baseball.util.setting.BallSetting.*;

public class Hint{
  private int strike = 0;
  private int ball = 0;

  public void countStrikeAndBall(Balls userNumbers, Balls computerNumbers){
    for(int i=0; i<BALL_SIZE.getBallSetting(); i++){
      strike += countStrike(userNumbers,computerNumbers,i);
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


  public int getStrike(){
    return strike;
  }

}
