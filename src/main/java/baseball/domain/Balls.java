package baseball.domain;

import static baseball.message.ExceptionMessage.*;
import static baseball.util.setting.BallSetting.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
  private final List<Integer> balls;

  public Balls(List<Integer> balls) {
    validateBallsSize(balls);
    validateDuplicateNumber(balls);
    this.balls = balls;
  }

  private void validateBallsSize(List<Integer> balls){
    if(!(balls.size()==BALL_SIZE.getBallSetting())){
      throw new IllegalArgumentException(INCORRECT_BALL_SIZE.getErrorMessage());
    }
  }

  private void validateDuplicateNumber(List<Integer> balls){
    Set<Integer> ballsSet = new HashSet<>(balls);
    if(ballsSet.size()!=BALL_SIZE.getBallSetting()){
      throw new IllegalArgumentException(DUPLICATE_NUMBER.getErrorMessage());
    }
  }

  public List<Integer> getBalls(){
    return balls;
  }
}
