package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

  BaseballGame game;
  MessagePrinter printer;

  private void init() {
    printer = new MessagePrinter();
    printer.printMessage(InGameMessages.GAME_START);
    game = new BaseballGame();
  }

  public void control() {
    init();
    do {
      game.start();
    } while (restartChecker());
  }

  private boolean restartChecker() {
    printer.printMessage(InGameMessages.GAME_RESTART_OR_END);
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
