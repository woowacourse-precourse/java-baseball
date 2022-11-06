package baseball;

import baseball.io.MessagePrinter;
import baseball.io.InputReader;

public class GameController {

  BaseballGame game;
  MessagePrinter printer;
  InputReader reader;

  private void init() {
    reader = new InputReader();
    printer = new MessagePrinter();
    printer.printMessage(InGameMessages.GAME_START);
    game = new BaseballGame();
  }

  public void control() {
    init();
    do {
      game.play();
    } while (checkRestart());
  }

  private boolean checkRestart() {
    printer.printMessage(InGameMessages.GAME_RESTART_OR_END);
    String input = reader.readRestartOrEndInput();

    // input을 입력받을때 validation을 끝냈기 떄문에 1인지 아닌지로만 판단
    return input.equals("1");
  }
}
