package baseball.view;

import baseball.domain.Hint;
import baseball.domain.Hints;

public class Output {

    private static final int BLANK = 0;
    private static final int END = 3;
    private static final String OUTPUT_START = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_INSTANTIATION_EXCEPTION = "Output 클래스는 생성할 수 없습니다.";
    private static final String NOTHING = "낫싱 ";
    private static final String BALL = "볼 ";
    private static final String GAME_END = END + "스트라이크\n" + END + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크 ";
    private static final String EMPTY = "";

    private Output() throws InstantiationException {
        throw new InstantiationException(OUTPUT_INSTANTIATION_EXCEPTION);
    }

    public static void start() {
        System.out.println(OUTPUT_START);
    }

    public static void result(Hints hints) {
        StringBuilder result = new StringBuilder();
        result.append(ball(hints.count(Hint.BALL)));
        result.append(strike(hints.count(Hint.STRIKE)));
        result.append(nothing(hints.isNothing()));
        System.out.println(result);
    }

    private static String nothing(boolean nothing) {
        if (nothing) {
            return NOTHING;
        }
        return EMPTY;
    }

    private static String ball(int count) {
        if (count == BLANK) {
            return EMPTY;
        }
        return count + BALL;
    }

    private static String strike(int count) {
        if (count == BLANK) {
            return EMPTY;
        }
        if (count == END) {
            return GAME_END;
        }
        return count + STRIKE;
    }
}
