package baseball;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    void 재시작여부입력_1과2_외의_숫자() {
        String[] arrays = {"7"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> illegalArgument.check(arrays, Game.intentionLength, Game.numberForIntention));
    }
}
