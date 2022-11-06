package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.GameNumberCalculatorService;
import baseball.service.GameStatusService;
import baseball.view.GameResultView;
import baseball.view.UserInputView;
import java.util.ArrayList;
import java.util.List;

public class GamePlayController {
    private static final int STRIKE_INDEX = 0;
    private static final int THREE_STRIKE = 3;
    private final GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();
    private final UserInputView userInputView = new UserInputView();
    private final GameResultView gameResultView = new GameResultView();
    private final GameStatusService gameStatusService = new GameStatusService();
    private Computer computer = new Computer();
    private User user = new User();
    private List<Integer> strikeAndBallCount = new ArrayList<>();

    public void getGameResult() {
        if (strikeAndBallCount.get(STRIKE_INDEX) == THREE_STRIKE) {
            gameResultView.printThreeStrikeResult();
            gameStatusService.processNextGameStatus(computer);
        }
        if (strikeAndBallCount.get(STRIKE_INDEX) != THREE_STRIKE) {
            gameResultView.printNotThreeStrikeResult(strikeAndBallCount);
        }
    }
}
