package baseball;

import baseball.model.BaseballNumbers;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private static final BaseballGame baseballGame = new BaseballGame();
    private static final String RESTART_INPUT = "1";
    private static final String END_INPUT = "2";
    private static final int ROUND_CLEAR_STRIKE_COUNT = 3;
    private static final String GAME_END_WRONG_ERROR_MESSAGE = "종료 조건 값에 올바르지 않은 값을 입력하였습니다.";
    private final BaseballGameView baseballGameView;

    private BaseballGame() {
        this.baseballGameView = BaseballGameView.getInstance();
    }

    public static BaseballGame getInstance() {
        return baseballGame;
    }

    public void startGame() {
        baseballGameView.printStartMessage();

        do {
            startRound();
        } while (!isEndGame());
    }

    private void startRound() {
        BaseballNumbers computerNumbers = new BaseballNumbers();
        boolean isRoundClear;

        do {
            BaseballNumbers userNumbers = getUserBaseballNumbers();
            List<Integer> comparedResult = computerNumbers.getComparedResult(userNumbers);
            baseballGameView.printComparedResult(comparedResult);
            isRoundClear = isRoundClear(comparedResult);
        } while (!isRoundClear);
    }

    private BaseballNumbers getUserBaseballNumbers() {
        baseballGameView.printInsertNumbersMessage();
        return new BaseballNumbers(Console.readLine());
    }

    private boolean isRoundClear(List<Integer> comparedResult) {
        return comparedResult.get(1) == ROUND_CLEAR_STRIKE_COUNT;
    }

    private boolean isEndGame() {
        baseballGameView.printGameEndMessage();
        String endStatus = Console.readLine();

        if (RESTART_INPUT.equals(endStatus)) {
            return false;
        } else if (END_INPUT.equals(endStatus)) {
            return true;
        }

        throw new IllegalArgumentException(GAME_END_WRONG_ERROR_MESSAGE);
    }
}
