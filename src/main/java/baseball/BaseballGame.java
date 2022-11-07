package baseball;

import baseball.View.Constant;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

  private Computer computer;
  private User user;
  private Count count;
  private boolean running;

  public BaseballGame() {
    computer = new Computer();
    user = new User();
    count = new Count();
    running = true;
  }

  public void start() {
    do {
      computer.makeNum();
      startGame();
    } while (isRestart());
  }

  public void startGame() {
    while (running) {
      user.inputNumber(readLine());

      count.count(computer.getAnswer(), user.getUserNumber());
      count.print();

      if (count.getStrike() == Constant.GAME_WIN_VALUE) {
        running = false;
        System.out.println(Constant.USER_WIN_MESSAGE);
      }
    }
  }

  private boolean isRestart() {
    System.out.println(Constant.RESTART_MESSAGE);

    int restart = Integer.parseInt(readLine());

    if (restart == Constant.RETRY) {
      this.running = true;
      return true;
    } else if (restart == Constant.GAME_OVER) {
      System.out.println(Constant.GAME_END_MESSAGE);
      return false;
    } else {
      throw new IllegalArgumentException(Constant.WRONG_INPUT);
    }
  }
}
