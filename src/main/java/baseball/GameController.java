package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

  public void start() {

  }

  public boolean restartChecker() {
    System.out.println(InGameMessages.GAME_RESTART_OR_END);
    String input = Console.readLine();
    if (input.equals("1")) {
      return true;
    } else if (input.equals("2")) {
      return false;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
