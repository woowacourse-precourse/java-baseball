package baseball.view;

import baseball.domain.GameResult;
import baseball.message.GameMessage;
import baseball.enums.GuessResultStatus;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
    private static final String EMPTY_MESSAGE = "";
    private static final int FULL_STRIKE = 3;
    private static final int NOTHING = 0;

    private GameResult gameResult;

    public void printStartGame() {
        System.out.println(GameMessage.START_GAME);
    }

    public String inputUserAnswer() {
        System.out.print(GameMessage.NUMBER_INPUT);
        return Console.readLine();
    }

    public String inputNewGameAnswer() {
        System.out.println(GameMessage.NEW_GAME);
        return Console.readLine();
    }

    public GuessResultStatus printResult(GameResult gameResult) {
        setGameResult(gameResult);
        if (isWin()) {
            System.out.println(createResultMessage());
            System.out.println(GameMessage.WIN);
            return GuessResultStatus.WIN;
        }
        if (isNothing()) {
            System.out.println(GameMessage.NOTHING);
            return GuessResultStatus.NOT_WIN;
        }
        System.out.println(createResultMessage());
        return GuessResultStatus.NOT_WIN;
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
            strikeMessage += gameResult.getStrike() + GameMessage.STRIKE;
        }
        if (gameResult.getBall() > NOTHING) {
            ballMessage += gameResult.getBall() + GameMessage.BALL;
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

    public void endGame() {
        System.out.println("애플리케이션을 종료합니다.");
    }
}
