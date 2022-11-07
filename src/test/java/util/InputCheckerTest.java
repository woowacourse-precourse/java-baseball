package util;

import baseball.util.InputChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputCheckerTest {

    @Test
    void 문자열_길이가_3이고_중복이_없는경우() {
        // given
        String input = "123";

        // when
        InputChecker.isValid(input);

        // then
    }

    @Test
    void 문자열_길이가_3이아닌경우() {
        // given
        String input = "12";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.isValid(input));
    }

    @Test
    void 문자열_길이가_3이고_중복이_있는경우() {
        // given
        String input = "112";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.isValid(input));
    }

    @Test
    void 숫자가_아닌_문자열이_들어오는경우() {
        // given
        String input = "a12";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.isValid(input));
    }
}
