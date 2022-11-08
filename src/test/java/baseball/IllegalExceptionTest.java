package baseball;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class IllegalExceptionTest {
    IllegalArgument illegalArgument = new IllegalArgument();

    @Test
    void 정답_문자_입력시_예외_발생() {
        String[] arrays = {"1", "2", "d"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.answerLength, Game.numberForAnswer));
    }

    @Test
    void 정답_3초과_횟수_입력시_예외_발생() {
        String[] arrays = {"1", "2", "3", "4"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.answerLength, Game.numberForAnswer));

    }

    @Test
    void 정답_중복포함_입력시_예외_발생() {
        String[] arrays = {"3", "4", "3"};

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.answerLength, Game.numberForAnswer));
    }

    @Test
    void 정답_0포함_입력시_예외_발생() {
        String[] arrays = {"2", "4", "0"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.answerLength, Game.numberForAnswer));
    }

    @Test
    void 재시작여부_1과2_외의_숫자_입력시_예외_발생() {
        String[] arrays = {"0"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.intentionLength, Game.numberForIntention));
    }

    @Test
    void 재시작여부_문자_입력시_예외발생() {
        String[] arrays = {"ㄷ"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.intentionLength, Game.numberForIntention));
    }

    @Test
    void 재시작여부_두글자_이상_입력시_예외발생() {
        String[] arrays = {"1", "1"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.intentionLength, Game.numberForIntention));
    }
}
