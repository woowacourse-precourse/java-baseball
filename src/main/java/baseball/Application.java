package baseball;

import baseball.generator.NextStepRandomGenerator;
import baseball.input.ConsoleInputReader;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer(new NextStepRandomGenerator());
        Player player = new Player(new ConsoleInputReader());
        new BaseBallGameManager(computer, player).runGame();
    }
}
