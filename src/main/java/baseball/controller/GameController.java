package baseball.controller;

import baseball.Constant;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static AnswerController answerController;
    private static ResultController resultController;

    private GameController() {
    }

    public static void run() {
        init();
        do {
            start();
        } while (wantRestart());
    }

    private static void init() {
        OutputView.gameStart();
        answerController = AnswerController.getInstance();
        resultController = ResultController.getInstance();
    }

    private static void start() {
        answerController.setCorrectAnswer();
        String guessAnswer;
        do {
            guessAnswer = answerController.getInputAnswer();
        } while (!resultController.getResult(guessAnswer));
    }

    private static boolean wantRestart() {
        OutputView.askRestart();
        String restartInput = InputView.getInput();
        if (restartInput.equals(Constant.RESTART_INPUT_NUMBER)) {
            return true;
        }
        if (restartInput.equals(Constant.EXIT_INPUT_NUMBER)) {
            return false;
        }
        throw new IllegalArgumentException(Constant.RESTART_INPUT_INVALID_ERROR_MESSAGE);
    }

}
