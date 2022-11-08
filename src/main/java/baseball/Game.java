package baseball;

import io.InputOutputController;

public class Game {

    private static final int ENDGAME = 1;
    private static final int PLAY_AGAIN_MODE = 2;
    private static final int PLAYING_MODE = 1;
    private static int inputLength;

    public Game() {
        InputOutputController.outputStartMessage();
    }

    public int startAndPlayAgain(int numberLength) {
        inputLength = numberLength;
        Referee.generateRandom(numberLength);
        progress();
        return checkContinueMode();
    }

    private static void progress() {
        while (true) {
            InputOutputController.outputInputMessage();
            String RefereeResult = InputOutputController.outputResultMessage(Referee.calculateAnswer(
                    InputOutputController.inputGet(PLAYING_MODE)));
            if (RefereeResult.equals(inputLength + "스트라이크")) {
                break;
            }
        }
    }

    private static int checkContinueMode() {
        InputOutputController.outputEndingMessage();
        if (InputOutputController.inputGet(PLAY_AGAIN_MODE).equals("1")) {
            return PLAY_AGAIN_MODE;
        }
        return ENDGAME;
    }
}
