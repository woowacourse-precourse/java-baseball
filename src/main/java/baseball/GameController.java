package baseball;

import baseball.constant.InGameMessages;
import baseball.io.MessagePrinter;
import baseball.io.InputReader;

public class GameController {

  MessagePrinter printer;
  InputReader reader;

  public GameController() {
    reader = new InputReader();
    printer = new MessagePrinter();

    printer.printlnMessage(InGameMessages.GAME_START.getMessage());
  }

  public void control() {
    BaseballGame game = new BaseballGame();
    do {
      game.play();
    } while (checkRestart());
  }

  boolean checkRestart() {
    printer.printlnMessage(InGameMessages.GAME_RESTART_OR_END.getMessage());
    String input = reader.readRestartOrEndInput();

    // input을 입력받을때 validation을 끝냈기 때문에 1인지 아닌지로만 판단
    return input.equals("1");
  }
}
