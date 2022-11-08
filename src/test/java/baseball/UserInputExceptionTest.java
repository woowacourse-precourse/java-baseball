package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserInputExceptionTest {

    @Test
    void checkUserNumberInput_숫자문자열_길이_확인() {
        String input = "1234";

        assertThatThrownBy(() ->
                UserInputException.checkUserNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberInput_숫자문자열_모두_숫자인지_확인() {
        String input = "12a";

        assertThatThrownBy(() ->
                UserInputException.checkUserNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberInput_숫자문자열_0포함_확인() {
        String input = "120";

        assertThatThrownBy(() ->
                UserInputException.checkUserNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberInput_숫자문자열_중복_확인() {
        String input = "121";

        assertThatThrownBy(() ->
                UserInputException.checkUserNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberInput_숫자문자열_올바른_입력_확인() {
        String input = "123";

        assertThat(UserInputException.checkUserNumberInput(input))
                .isEqualTo(true);
    }

    @Test
    void checkUserRestartInput_재시작문자열_옳지않은_입력_확인() {
        String input = "3";

        assertThatThrownBy(() ->
                UserInputException.checkUserRestartInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserRestartInput_재시작문자열_올바른_입력_확인_1() {
        String input = "1";

        assertThat(UserInputException.checkUserRestartInput(input))
                .isEqualTo(true);
    }

    @Test
    void checkUserRestartInput_재시작문자열_올바른_입력_확인_2() {
        String input = "2";

        assertThat(UserInputException.checkUserRestartInput(input))
                .isEqualTo(true);
    }
}
