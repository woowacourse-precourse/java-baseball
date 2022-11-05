package baseball.view;

import baseball.domain.Hint;
import baseball.domain.Hints;

public class Output {

    private static final int BLANK = 0;
    private static final int END = 3;

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
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
            return "낫싱 ";
        }
        return "";
    }

    private static String ball(int count) {
        if (count == BLANK) {
            return "";
        }
        return count + "볼 ";
    }

    private static String strike(int count) {
        if (count == BLANK) {
            return "";
        }
        if (count == END) {
            return END + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return count + "스트라이크 ";
    }
}
