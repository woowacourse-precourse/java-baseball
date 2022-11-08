package baseball;

import IOController.InputOutputController;

public class Application {

    private static final int PLAYAGAINMODE = 2;
    private static final int INPUT_CONSOLEMODE = 1;
    private static final int OUTPUT_CONSOLEMODE = 1;
    //private static final int OUTPUT_TXTMODE = 2; -> 출력을 텍스트파일에다 하겠다
    //private static final int INPUT_TXTMODE = 2 -> 입력을 텍스트파일로 넣어서 한줄씩 읽겠다.
    private static final int INPUTLENGTH = 3;

    public static void main(String[] args) {
        Game game = new Game();
        InputOutputController ioController = new InputOutputController(INPUT_CONSOLEMODE, OUTPUT_CONSOLEMODE, INPUTLENGTH);

        int playAgainReturn;
        do {
            playAgainReturn = game.startAndPlayAgain(ioController);
        } while (playAgainReturn == PLAYAGAINMODE);
    }
}
