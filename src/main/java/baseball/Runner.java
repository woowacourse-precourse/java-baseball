package baseball;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.dto.GameInputNumber;
import baseball.dto.InputSignal;
import baseball.game.BaseballGame;
import baseball.game.GameResult;
import baseball.game.RandomNumberGenerator;

public class Runner {

  private final ConsoleInput consoleInput;
  private final ConsoleOutput consoleOutput;
  private final RandomNumberGenerator numberGenerator;

  public Runner(ConsoleInput consoleInput, ConsoleOutput consoleOutput,
      RandomNumberGenerator numberGenerator) {
    this.consoleInput = consoleInput;
    this.consoleOutput = consoleOutput;
    this.numberGenerator = numberGenerator;
  }

  public void run() {
    consoleOutput.printStartMessage();

    BaseballGame game = new BaseballGame(numberGenerator.generate());

    while (true) {
      GameInputNumber number = consoleInput.inputNumber();
      GameResult result = game.start(number);
      consoleOutput.printResult(result);

      if (!isAllStrike(result)) {
        continue;
      }

      if (isGameEnd()) {
        break;
      }

      game = new BaseballGame(numberGenerator.generate());
    }
  }

  private boolean isGameEnd() {
    consoleOutput.printEndMessage();
    InputSignal inputSignal = consoleInput.inputSignal();

    return inputSignal.getSignal().equals(2);
  }


  private boolean isAllStrike(GameResult result) {
    return result.getStrike().equals(3);
  }
}
