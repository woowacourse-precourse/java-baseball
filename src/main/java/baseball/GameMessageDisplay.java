package baseball;

import java.util.Map;

public class GameMessageDisplay {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STOP_OR_REGAME_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String BALL = "ball";
    public static final String STRIKE = "strike";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    public void printInputRequestMessage() {
        System.out.print(INPUT_REQUEST_MESSAGE);
    }
    public void printStopOrRegameRequestMessage() {
        System.out.println(STOP_OR_REGAME_REQUEST_MESSAGE);
    }
    public void printGameResultMessage(Map<String, Integer> gameResult) {
        String gameResultMessage = getGameResultMessage(gameResult);
        System.out.println(gameResultMessage);
    }
    public String getGameResultMessage(Map<String, Integer> gameResult) {
        int ball = gameResult.get(BALL);
        int strike = gameResult.get(STRIKE);

        if (strike == 3) {
            return strike + STRIKE_MESSAGE + "\n" + SUCCESS_MESSAGE;
        }
        if (strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        }
        if (strike == 0) {
            return ball + BALL_MESSAGE;
        }
        if (ball == 0) {
            return strike + STRIKE_MESSAGE;
        }
        return ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE;
    }
}
