package baseball;

import baseball.io.MessagePrinter;
import baseball.io.InputReader;

import java.util.List;

public class BaseballGame {

  MessagePrinter printer;
  InputReader reader;
  List<Integer> computerNumber;
  ScoreCounter scoreCounter;
  int strikeCount;
  int ballCount;

  public BaseballGame() {
    printer = new MessagePrinter();
    reader = new InputReader();
    scoreCounter = new ScoreCounter();
  }

  private List<Integer> getComputerNumber() {
    Computer computer = new Computer();
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
      printScore(strikeCount, ballCount);
    }
  }

  private void initCount() {
    strikeCount = 0;
    ballCount = 0;
  }

  private void printScore(int strikeCount, int ballCount) {
    String strike = InGameTerms.STRIKE.getTerm();
    String ball = InGameTerms.BALL.getTerm();
    if(scoreCounter.strikeCount == 3) {
      printer.printlnMessage(strikeCount + strike);
      printer.printlnMessage(InGameMessages.GAME_END.getMessage());
    } else if (ballCount > 0 && strikeCount > 0) {
      printer.printlnMessage(ballCount + ball + " " + strikeCount + strike);
    } else if (ballCount > 0) {
      printer.printlnMessage(ballCount + ball);
    } else if (strikeCount > 0) {
      printer.printlnMessage(strikeCount + strike);
    } else {
      printer.printlnMessage(InGameTerms.NOTHING.getTerm());
    }
  }

}
