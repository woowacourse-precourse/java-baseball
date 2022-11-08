package baseball.controller;

import baseball.domain.GameResult;
import baseball.enums.GuessResultStatus;
import baseball.sevice.NumberBaseballService;
import baseball.validator.UserAnswerValidator;
import baseball.view.NumberBaseballView;
import java.util.List;

public class NumberBaseballController {
    private static final String RESTART = "1";
    private static final String END = "2";

    private final NumberBaseballService numberBaseballService = new NumberBaseballService();
    private final NumberBaseballView numberBaseballView = new NumberBaseballView();
    private final UserAnswerValidator userAnswerValidator = new UserAnswerValidator();

    public void startGame() {
        numberBaseballService.initNumber();
        numberBaseballView.printStartGame();
        inputUserAnswer();
    }

    public void restartGame() {
        numberBaseballService.initNumber();
        inputUserAnswer();
    }

    public void inputUserAnswer() {
        List<Integer> resultList = numberBaseballService.inputUserAnswer(numberBaseballView.inputUserAnswer());
        GameResult gameResult = new GameResult(resultList);
        GuessResultStatus resultType = numberBaseballView.printResult(gameResult);
        determineNextMove(resultType);
    }

    public void determineNextMove(GuessResultStatus resultType) {
        if (resultType == GuessResultStatus.WIN) {
            inputNewGameAnswer();
        }
        if (resultType == GuessResultStatus.NOT_WIN) {
            inputUserAnswer();
        }
    }

    public void inputNewGameAnswer() {
        String userAnswer = numberBaseballView.inputNewGameAnswer();
        userAnswerValidator.validateNewGameAnswer(userAnswer);
        if (userAnswer.equals(RESTART)) {
            restartGame();
        }
        if (userAnswer.equals(END)) {
            numberBaseballView.endGame();
        }
    }

}
