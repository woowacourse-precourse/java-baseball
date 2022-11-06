package baseball.controller;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;
import baseball.service.NumberBaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class NumberBaseballGameController {

    private static final String STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY = "Strike";
    private static final String STRIKE_AND_BALL_COUNT_MAP_BALL_KEY = "Ball";
    private static final int THREE_STRIKE_COUNT = 3;
    private static final String GAME_RESTART_NUMBER = "1";
    private static final String GAME_END_NUMBER = "2";
    private static final String GAME_RESTART_STATUS = "play";
    private static final String GAME_END_STATUS = "end";

    private static String gameStatus = GAME_RESTART_STATUS;

    NumberBaseballGameService numberBaseballGameService = new NumberBaseballGameService();

    public void run() {
        while (gameStatus.equals(GAME_RESTART_STATUS)) {
            gameInit();
            gameStart();
            gamePlay();
            gameRestartOrEnd();
        }
    }

    public void gameInit() {
        numberBaseballGameService.generateOpponentComputer();
    }

    public void gameStart() {
        OutputView.printGameStartMessage();
    }

    public void gamePlay() {
        while (numberBaseballGameService.getStrikeCount() != THREE_STRIKE_COUNT) {
            String playerNumber = InputView.inputNumber();
            Map<String, Integer> strikeAndBallCountMap =
                    numberBaseballGameService.judgeStrikeOrBallCount(playerNumber);
            OutputView.printGameResultMessage(
                    strikeAndBallCountMap.get(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY),
                    strikeAndBallCountMap.get(STRIKE_AND_BALL_COUNT_MAP_BALL_KEY)
            );
        }
    }

    public void gameRestartOrEnd() {
        String restartOrEndNumber = InputView.inputRestartOrEndNumber();
        if (restartOrEndNumber.equals(GAME_RESTART_NUMBER)) {
            gameStatus = GAME_RESTART_STATUS;
        }
        if (restartOrEndNumber.equals(GAME_END_NUMBER)) {
            gameStatus = GAME_END_STATUS;
        }
    }
}
