package baseball.view;

import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTING_MESSAGE = "낫싱";
    private static final String EMPTY_MESSAGE = "";
    private static final int WIN = 1;
    private static final int NOT_WIN = 0;
    private static final int FULL_STRIKE = 3;
    private static final int NOTHING = 0;

    private GameResult gameResult;
    private StringBuilder result = new StringBuilder();

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public String inputUserAnswer() {
        System.out.print(NUMBER_INPUT);
        return Console.readLine();
    }

    public String inputNewGameAnswer() {
        System.out.println(NEW_GAME_MESSAGE);
        return Console.readLine();
    }

    public int printResult(GameResult gameResult) {
        setGameResult(gameResult);
        if (isWin()) {
            System.out.println(WIN_MESSAGE);
            return WIN;
        }
        if (isNothing()) {
            System.out.println(NOTING_MESSAGE);
            return NOT_WIN;
        }
        System.out.println(createResultMessage());
        return NOT_WIN;
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
            strikeMessage += gameResult.getStrike() + STRIKE;
        }
        if (gameResult.getBall() > NOTHING) {
            ballMessage += gameResult.getBall() + BALL;
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
