package baseball;

import io.InputOutputController;

public class Application {

    private static final int PLAY_AGAIN_MODE = 2;
    private static final int INPUT_CONSOLE_MODE = 1;
    private static final int OUTPUT_CONSOLE_MODE = 1;
    private static final int INPUT_LENGTH = 3;

    public static void main(String[] args) {
        InputOutputController ioController;
        ioController = new InputOutputController(INPUT_CONSOLE_MODE, OUTPUT_CONSOLE_MODE, INPUT_LENGTH);
        Game game = new Game();
        int playAgainReturn;
        do {
            playAgainReturn = game.startAndPlayAgain(INPUT_LENGTH);
        } while (playAgainReturn == PLAY_AGAIN_MODE);
    }
}
