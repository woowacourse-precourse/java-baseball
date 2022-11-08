package baseball.Model.Computer;

import java.util.List;
import java.util.stream.IntStream;

public final class Referee {

    private static final int FIRST_NUM = 0;
    private static final int SECOND_NUM = 1;
    private static final int THIRD_NUM = 2;

    private int ball;
    private int strike;

    public boolean count(final List<Character> answer, final String comparison) {
        IntStream.range(0, 3).forEach(i -> {
            if (answer.get(i) == comparison.charAt(i)) {
                strike++;
            } else if (answer.contains(comparison.charAt(i))) {
                ball++;
            }
        });
        judge(answer, comparison);
        return strike == 3;
    }

    private void judge(final List<Character> answer, final String comparison) {
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if ((answer.get(FIRST_NUM) != comparison.charAt(FIRST_NUM)) &&
            (answer.get(SECOND_NUM) != comparison.charAt(SECOND_NUM)) &&
            (answer.get(THIRD_NUM) != comparison.charAt(THIRD_NUM))) {
            System.out.println("낫싱");
        }
    }
}
