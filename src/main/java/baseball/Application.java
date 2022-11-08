package baseball;

import IOController.InputOutputController;

public class Application {

    private static final int PLAY_AGAIN_MODE = 2;
    private static final int INPUT_CONSOLE_MODE = 1;
    private static final int OUTPUT_CONSOLE_MODE = 1;
    //private static final int OUTPUT_TXTMODE = 2; -> 출력을 텍스트파일에다 하겠다
    //private static final int INPUT_TXTMODE = 2 -> 입력을 텍스트파일로 넣어서 한줄씩 읽겠다.
    private static final int INPUTLENGTH = 4;

    public static void main(String[] args) {
        Game game = new Game();
        InputOutputController ioController = new InputOutputController(INPUT_CONSOLE_MODE, OUTPUT_CONSOLE_MODE, INPUTLENGTH);

        int playAgainReturn;
        do {
            playAgainReturn = game.startAndPlayAgain(ioController, INPUTLENGTH);
        } while (playAgainReturn == PLAY_AGAIN_MODE);
    }
}
