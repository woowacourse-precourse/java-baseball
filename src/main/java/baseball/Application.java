package baseball;

import baseball.domain.Game;
import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
import baseball.ui.Input;
import baseball.ui.Output;

public class Application {

    private static final int BALL_MAX_COUNT = 3;

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Game game = new Game(BALL_MAX_COUNT);
        game.execute(input, output);
    }
}
