package baseball;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.game.RandomNumberGenerator;

public class Application {

  public static void main(String[] args) {
    ConsoleInput input = new ConsoleInput();
    ConsoleOutput output = new ConsoleOutput();
    RandomNumberGenerator generator = new RandomNumberGenerator();

    Runner runner = new Runner(input, output, generator);
    runner.run();
  }
}
