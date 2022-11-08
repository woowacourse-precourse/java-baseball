package study;

import baseball.Exception.InputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest {

    @Test
    void isDigits_메소드로_숫자인지_리턴() {
        String input[] = {"123", "2345", "1a3", "1 2"};
        boolean result[] = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = InputException.isDigits(input[i]);
        }

        assertThat(result).contains(true, false);
        assertThat(result).containsExactly(true, true, false, false);
    }

    @Test
    void containZero_메소드로_0을_포함하는지_리턴() {
        String input[] = {"123", "456", "012", "302", "126"};
        boolean result[] = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = InputException.containZero(input[i]);
        }

        assertThat(result).contains(false, true);
        assertThat(result).containsExactly(false, false, true, true, false);
    }

    @Test
    void isDuplicate_메소드로_중복된_숫자를_포함하는지_리턴() {
        String input[] = {"123", "454", "312", "363", "111"};
        boolean result[] = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = InputException.isDuplicate(input[i]);
        }

        assertThat(result).contains(false, true);
        assertThat(result).containsExactly(false, true, false, true, true);
    }

    @Test
    void isValidInput_메소드로_사용자_입력이_올바른지_확인() {
        String input[] = {"123", "456", "012", "122", "1234", "368", "-123"};
        boolean result[] = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = InputException.isValidInput(input[i]);
        }

        assertThat(result).contains(true, false);
        assertThat(result).containsExactly(true, true, false, false, false, true, false);

    }

    @Test
    void isValidRestartInput_메소드로_재시작_입력이_올바른지_확인() {
        String input[] = {"1", "2", "Y", "N", "\n", " "};
        boolean result[] = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = InputException.isValidRestartInput(input[i]);
        }

        assertThat(result).contains(true, false);
        assertThat(result).containsExactly(true, true, false, false, false, false);
    }
}
