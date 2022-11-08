package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.ScoreCalculator;
import baseball.service.GameService;
import baseball.view.GameResult;
import baseball.view.InputRequester;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final int STRIKE_INDEX = 0;
    private static final int THREE_STRIKE = 3;
    private final InputRequester userInputView = new InputRequester();
    private final GameResult gameResultView = new GameResult();
    private final GameService gameStatusService = new GameService();
    private final ScoreCalculator gameNumberCalculatorService = new ScoreCalculator();
    private List<Integer> strikeAndBallCount = new ArrayList<>();
    private Computer computer = new Computer();
    private User user = new User();

    public void startGame() {
        computer.setupGameNumbers();
        while (!gameStatusService.isExitGame()) {
            inputUserNumber();
            calculateStrikeAndBallCount();
            getGameResult();
        }
    }

    public void inputUserNumber() {
        user.setUserGameNumbers(userInputView.setUserGameNumbers());
    }

    public void calculateStrikeAndBallCount() {
        strikeAndBallCount = gameNumberCalculatorService.calculateGameNumber(user.getUserGameNumbers(),
                computer.getComputerGameNumbers());
    }

    public void getGameResult() {
        if (strikeAndBallCount.get(STRIKE_INDEX) == THREE_STRIKE) {
            gameResultView.printThreeStrikeResult();
            gameStatusService.processNextGameStatus(computer);
        }
        if (strikeAndBallCount.get(STRIKE_INDEX) != THREE_STRIKE) {
            gameResultView.printNotThreeStrikeResult(strikeAndBallCount);
        }
    }

    public Controller() {
        gameResultView.printCreateController();
    }
}