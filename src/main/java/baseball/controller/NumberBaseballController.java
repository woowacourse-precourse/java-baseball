package baseball.controller;

import baseball.domain.GameResult;
import baseball.sevice.NumberBaseballService;
import baseball.view.NumberBaseballView;
import java.util.List;

public class NumberBaseballController {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private static final int WIN = 0;
    private static final int NOT_WIN = 1;
    private final NumberBaseballService numberBaseballService = new NumberBaseballService();
    private final NumberBaseballView numberBaseballView = new NumberBaseballView();

    public void startGame() {
        numberBaseballService.initNumber();
        numberBaseballView.printStartGame();
        inputUserAnswer();
    }

    private void inputUserAnswer() {
        List<Integer> resultList = numberBaseballService.inputUserAnswer(numberBaseballView.inputUserAnswer());
        GameResult gameResult = new GameResult(resultList.get(STRIKE_INDEX), resultList.get(BALL_INDEX));
        int userInputResult = numberBaseballView.printResult(gameResult);
        determineNextMove(userInputResult);
    }

    private void determineNextMove(int userInputResult) {
        if (userInputResult == WIN) {
            String userAnswer = numberBaseballView.inputNewGameAnswer();
        }
    }

}
