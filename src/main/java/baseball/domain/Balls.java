package baseball.domain;

import static baseball.message.ExceptionMessage.*;
import static baseball.util.setting.BallSetting.*;

import java.util.List;

public class Balls {
  private final List<Integer> balls;

  public Balls(List<Integer> balls) {
    validateBallsSize(balls);
    this.balls = balls;
  }

  private void validateBallsSize(List<Integer> balls){
    if(!(balls.size()==BALL_SIZE.getBallSetting())){
      throw new IllegalArgumentException(INCORRECT_BALL_SIZE.getErrorMessage());
    }
  }

  public List<Integer> getBalls(){
    return balls;
  }
}
