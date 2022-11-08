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
        requestUserAnswer();
    }

    public void restartGame() {
        numberBaseballService.initNumber();
        requestUserAnswer();
    }

    public void requestUserAnswer() {
        List<Integer> resultList = numberBaseballService.createResultList(numberBaseballView.inputUserAnswer());
        printGameResult(resultList);
    }

    public void printGameResult(List<Integer> resultList) {
        GameResult gameResult = new GameResult(resultList);
        GuessResultStatus resultType = numberBaseballView.printResult(gameResult);
        determineNextMoveForUserAnswer(resultType);
    }

    public void determineNextMoveForUserAnswer(GuessResultStatus resultType) {
        if (resultType == GuessResultStatus.WIN) {
            requestNewGameAnswer();
        }
        if (resultType == GuessResultStatus.NOT_WIN) {
            requestUserAnswer();
        }
    }

    public void requestNewGameAnswer() {
        String userAnswer = numberBaseballView.inputNewGameAnswer();
        userAnswerValidator.validateNewGameAnswer(userAnswer);
        determineNextMoveForNewGameAnswer(userAnswer);
    }

    public void determineNextMoveForNewGameAnswer(String userAnswer) {
        if (userAnswer.equals(RESTART)) {
            restartGame();
        }
        if (userAnswer.equals(END)) {
            numberBaseballView.endGame();
        }
    }

}
