package baseball;

import ui.ConsoleInput;
import ui.ConsoleOutput;
import ui.Input;
import ui.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Game game = new Game(3);
        game.run(input, output);
    }
}
