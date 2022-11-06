package baseball;

import baseball.io.MessagePrinter;
import baseball.io.InputReader;

import java.util.List;

public class BaseballGame {

  MessagePrinter printer;
  InputReader reader;
  Computer computer;
  List<Integer> computerNumber;
  ScoreCounter scoreCounter;
  int strikeCount;
  int ballCount;

  private void init() {
    printer = new MessagePrinter();
    reader = new InputReader();
    scoreCounter = new ScoreCounter();
    computerNumber = getComputerNumber();
  }

  private List<Integer> getComputerNumber() {
    computer = new Computer();
    return computer.generateRandomNumber();
  }

  public void play() {
    init();

    while (strikeCount != 3) {
      printer.printMessage(InGameMessages.ENTER_NUMBER.getMessage());
      String input = reader.readPlayingInput();

      scoreCounter.count(computerNumber, input);
      strikeCount = scoreCounter.strikeCount;
      ballCount = scoreCounter.ballCount;
    }
  }

}
