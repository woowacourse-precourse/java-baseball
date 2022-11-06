package baseball.converter;

import baseball.console.converter.RestartOrExitCodeConverter;
import baseball.exception.InputNumberFormatException;
import baseball.exception.InvalidStatusCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartOrExitCodeConverterTest {

    RestartOrExitCodeConverter converter;

    @BeforeEach
    void init() {
        converter = new RestartOrExitCodeConverter();
    }

    @Test
    @DisplayName("0 입력")
    void inputString_0() {
        //given
        String inputString = "0";

        //when
        Integer restartOrExitCode = converter.getRestartOrExitCode(inputString);

        //then
        assertThat(restartOrExitCode).isEqualTo(0);
    }

    @Test
    @DisplayName("1 입력")
    void inputString_1() {
        //given
        String inputString = "1";

        //when
        Integer restartOrExitCode = converter.getRestartOrExitCode(inputString);

        //then
        assertThat(restartOrExitCode).isEqualTo(1);
    }

    @Test
    @DisplayName("문자 입력 예외")
    void inputNumberFormatException() {
        //given
        String inputString = "asdf";

        //when then
        assertThatThrownBy(() -> converter.getRestartOrExitCode(inputString))
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage("잘못된 숫자 입력입니다. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("입력 코드 예외 - 3")
    void InvalidStatusCodeException_case1() {
        //given
        String inputString = "3";

        //when then
        assertThatThrownBy(() -> converter.getRestartOrExitCode(inputString))
                .isInstanceOf(InvalidStatusCodeException.class)
                .hasMessage("0 또는 1을 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("입력 코드 예외 - 01")
    void InvalidStatusCodeException_case2() {
        //given
        String inputString = "01";

        //when then
        assertThatThrownBy(() -> converter.getRestartOrExitCode(inputString))
                .isInstanceOf(InvalidStatusCodeException.class)
                .hasMessage("0 또는 1을 입력해주세요. 입력 문자: " + inputString);
    }
}