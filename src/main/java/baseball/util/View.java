package baseball.util;

import baseball.domain.Hint;
import java.util.List;

public class View {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_GUESS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REQUEST_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int ZERO = 0;
    private static final String HINT_NOTHING = "낫싱";
    private static final String HINT_STRIKE = "스트라이크";
    private static final String HINT_BALL = "볼";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRequestPlayerGuess() {
        System.out.print(REQUEST_GUESS_MESSAGE);
    }

    public static void printGameFinish() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    public static void printRequestRestart() {
        System.out.println(REQUEST_RESTART_MESSAGE);
    }

    public static void printHint(Hint hint) {
        StringBuilder sb = new StringBuilder();
        List<Integer> strikeBall = hint.getStrikeBallCount();
        Integer strike = strikeBall.get(0);
        Integer ball = strikeBall.get(1);

        if ((strike == ZERO) && (ball == ZERO)) {
            sb.append(HINT_NOTHING);
        }
        if (ball != ZERO) {
            sb.append(ball).append(HINT_BALL);
        }
        if (strike != ZERO) {
            if (!sb.toString().isBlank()) {
                sb.append(" ");
            }
            sb.append(strike).append(HINT_STRIKE);
        }

        System.out.println(sb);
    }
}
