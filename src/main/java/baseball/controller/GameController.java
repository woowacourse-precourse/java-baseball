package baseball.controller;

import static baseball.message.InputMessage.*;
import static baseball.util.setting.BallSetting.*;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Hint;
import baseball.domain.User;
import baseball.message.InputMessage;
import baseball.view.OutputView;

public class GameController {
  private final User user;
  private final Computer computer;

  public GameController(User user, Computer computer) {
    this.user = user;
    this.computer = computer;
  }

  public void playGame(){
    Balls computerBalls = computer.generateBalls();
    while(true){
      OutputView.printMessage(INPUT_PLAYER_BALLS.getMessage());
      Balls userBalls = user.generateBalls();
      Hint judgement = judge(userBalls, computerBalls);
      OutputView.printMessage(judgement.toString());
      if(checkThreeStrike(judgement)){
        break;
      }
    }
  }

  public Hint judge(Balls userBalls, Balls computerBalls){
    Hint hint = new Hint();
    hint.countStrikeAndBall(userBalls, computerBalls);
    return hint;
  }

  public boolean checkThreeStrike(Hint hint){
    return (hint.getStrike() == BALL_SIZE.getBallSetting());
  }

}
