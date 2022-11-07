package baseball;

import baseball.constant.InGameMessages;
import baseball.constant.InGameTerms;
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

  public BaseballGame() {
    printer = new MessagePrinter();
    reader = new InputReader();
    scoreCounter = new ScoreCounter();
    computer = new Computer();
  }

  private List<Integer> getComputerNumber() {
    return computer.generateRandomNumber();
  }

  public void play() {
    initCount();
    computerNumber = getComputerNumber();
    while (strikeCount != 3) {
      printer.printMessage(InGameMessages.ENTER_NUMBER.getMessage());
      String input = reader.readPlayingInput();

      scoreCounter.count(computerNumber, input);

      strikeCount = scoreCounter.strikeCount;
      ballCount = scoreCounter.ballCount;
      computer.printScore(strikeCount, ballCount);
    }
  }

  private void initCount() {
    strikeCount = 0;
    ballCount = 0;
  }

}
