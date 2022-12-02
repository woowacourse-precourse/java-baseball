package baseball.core;

import baseball.type.GameStatus;
import baseball.type.SuccessCondition;

import java.util.HashMap;
import java.util.Map;

public class BaseballGame {

    private final int NUMBER_TO_COMPLETE = 3;

    private BaseballNumber baseballNumber;
    private GameStatusOperator gameStatusOperator;

    protected BaseballGame(BaseballNumber baseballNumber, GameStatusOperator gameStatusOperator) {
        this.baseballNumber = baseballNumber;
        this.gameStatusOperator = gameStatusOperator;
    }

    public static BaseballGame initBaseballGame() {
        BaseballNumber baseballNumber = GameInitializer.initBaseballNumber();
        GameStatusOperator gameStatusOperator = GameInitializer.initGameStatusOperator();
        return new BaseballGame(baseballNumber, gameStatusOperator);
    }

    public void startGame() {
        gameStatusOperator.setGameStatus(GameStatus.ONGOING);
    }

    public Map<String, Integer> executeGameRound(String inputNumber) {
        int numberOfBall = baseballNumber.countTheNumberOfBall(inputNumber);
        int numberOfStrike = baseballNumber.countTheNumberOfStrike(inputNumber);
        gameStatusOperator.updateNumberOfBall(numberOfBall);
        gameStatusOperator.updateNumberOfStrike(numberOfStrike);
        return new HashMap<>() {{
            put("ball", numberOfBall);
            put("strike", numberOfStrike);
        }};
    }

    public SuccessCondition checkSuccessOrFail() {
        int numberOfStrike = gameStatusOperator.getNumberOfStrike();
        if (numberOfStrike == NUMBER_TO_COMPLETE) return SuccessCondition.SUCCESS;
        return SuccessCondition.FAIL;
    }

    public GameStatus executeGameByCommand(String gameCommand) {
        return gameStatusOperator.changeGameStatus(gameCommand);
    }

    public GameStatus getCurrentStatus() {
        return gameStatusOperator.getGameStatus();
    }
}
