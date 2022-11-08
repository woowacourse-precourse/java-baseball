package baseball;

import ui.ConsoleInput;
import ui.ConsoleOutput;
import ui.Input;
import ui.Output;

public class Application {
    private static final int BALL_MAX_COUNT = 3;
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Game game = new Game(BALL_MAX_COUNT);
        game.run(input, output);
    }
}
