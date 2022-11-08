package baseball.controller;

import static baseball.message.GameMessage.*;
import static baseball.message.InputMessage.*;
import static baseball.util.setting.BallSetting.*;
import static baseball.util.setting.MenuSetting.*;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Hint;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
  private final User user;
  private final Computer computer;

  public GameController(User user, Computer computer) {
    this.user = user;
    this.computer = computer;
  }

  public void run(){
    OutputView.printMessage(START_GAME.getMessage());
    playGame();
    while(InputView.inputMenu() == RESTART_GAME.getMenuNumber()){
      playGame();
    }
  }

  private void playGame(){
    Balls computerBalls = computer.generateBalls();
    while(true){
      OutputView.printInputMessage(INPUT_PLAYER_BALLS.getMessage());
      Balls userBalls = user.generateBalls();
      Hint judgement = judge(userBalls, computerBalls);
      OutputView.printMessage(judgement.toString());
      if(checkThreeStrike(judgement)){
        OutputView.printMessage(STRIKE_OUT.getMessage());
        break;
      }
    }
    OutputView.printMessage(ASK_RESTART_GAME.getMessage());
  }

  private Hint judge(Balls userBalls, Balls computerBalls){
    Hint hint = new Hint();
    hint.countStrikeAndBall(userBalls, computerBalls);
    return hint;
  }

  private boolean checkThreeStrike(Hint hint){
    return (hint.getStrike() == BALL_SIZE.getBallSetting());
  }

}
