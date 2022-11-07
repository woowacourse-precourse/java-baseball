package baseball.view;

import baseball.domain.GameResult;
import baseball.message.GameMessage;
import baseball.enums.GuessResultType;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
    private static final String EMPTY_MESSAGE = "";
    private static final int FULL_STRIKE = 3;
    private static final int NOTHING = 0;

    private GameResult gameResult;

    public void printStartGame() {
        System.out.println(GameMessage.START_GAME.getMessage());
    }

    public String inputUserAnswer() {
        System.out.print(GameMessage.NUMBER_INPUT.getMessage());
        return Console.readLine();
    }

    public String inputNewGameAnswer() {
        System.out.println(GameMessage.NEW_GAME.getMessage());
        return Console.readLine();
    }

    public GuessResultType printResult(GameResult gameResult) {
        setGameResult(gameResult);
        if (isWin()) {
            System.out.println(GameMessage.WIN.getMessage());
            return GuessResultType.WIN;
        }
        if (isNothing()) {
            System.out.println(GameMessage.NOTHING.getMessage());
            return GuessResultType.NOT_WIN;
        }
        System.out.println(createResultMessage());
        return GuessResultType.NOT_WIN;
    }

    private boolean isNothing() {
        return gameResult.getStrike() == NOTHING && gameResult.getBall() == NOTHING;
    }

    private boolean isWin() {
        return gameResult.getStrike() == FULL_STRIKE;
    }

    public String createResultMessage() {
        String strikeMessage = EMPTY_MESSAGE;
        String ballMessage = EMPTY_MESSAGE;
        if (gameResult.getStrike() > NOTHING) {
            strikeMessage += gameResult.getStrike() + String.valueOf(GameMessage.STRIKE.getMessage());
        }
        if (gameResult.getBall() > NOTHING) {
            ballMessage += gameResult.getBall() + String.valueOf(GameMessage.BALL.getMessage());
        }
        if (gameResult.getStrike() == NOTHING) {
            return ballMessage;
        }
        if (gameResult.getBall() == NOTHING) {
            return strikeMessage;
        }
        return ballMessage + " " + strikeMessage;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
