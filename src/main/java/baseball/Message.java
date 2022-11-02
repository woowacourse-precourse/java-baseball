package baseball;

import static baseball.BaseballGame.*;

public class Message {
    public static String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static final String USER_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ASK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String END_GAME = "숫자 야구 게임을 종료합니다.";

    public static String gameResult() {
        if (ball != 0 && strike != 0) {
            return (ball + "볼" + " " + strike + "스트라이크");
        } else if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            return (ball + "볼");
        } else {
            return ("낫싱");
        }
    }
}
