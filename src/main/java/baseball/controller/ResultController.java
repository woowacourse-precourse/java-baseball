package baseball.controller;

import static baseball.Constant.CORRECT_ANSWER_NUMBER_SIZE;

import baseball.service.ResultService;
import baseball.view.OutputView;

public class ResultController {
    private static ResultController instance;
    private static ResultService resultService;

    private ResultController() {
    }

    public static ResultController getInstance() {
        if (instance == null) {
            instance = new ResultController();
            resultService = ResultService.getInstance();
        }
        return instance;
    }

    public boolean getResult(String guessAnswer) {
        int[] result = resultService.calculateResult(guessAnswer);
        int strike = result[0];
        int ball = result[1];
        OutputView.printGuessResult(strike, ball);
        if (strike == CORRECT_ANSWER_NUMBER_SIZE) {
            OutputView.printSuccessResult();
            return true;
        }
        return false;
    }
}
