package baseball;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IllegalExceptionTest {
    IllegalArgument illegalArgument = new IllegalArgument();

    @Test
    void 입력_문자() {
        String[] arrays = {"1","2","d"};
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->illegalArgument.check(arrays, Game.answerLength));
    }

    @Test
    void 입력_3초과() {
        String[] arrays = {"1","2","3","4"};
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->illegalArgument.check(arrays, Game.answerLength));

    }

    @Test
    void 입력_중복포함() {
        String[] arrays = {"3","4","3"};
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->illegalArgument.check(arrays, Game.answerLength));
    }

    @Test
    void 입력_0포함() {
        String[] arrays = {"2","4","0"};
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->illegalArgument.check(arrays, Game.answerLength));
    }
}
