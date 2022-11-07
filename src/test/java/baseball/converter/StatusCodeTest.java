package baseball.converter;

import baseball.core.StatusCode;
import baseball.exception.InvalidStatusCodeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.core.StatusCode.EXIT_CODE;
import static baseball.core.StatusCode.START_CODE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StatusCodeTest {

    @Test
    @DisplayName("1 입력")
    void inputString_1() {
        //given
        String inputString = "1";

        //when
        StatusCode start = StatusCode.from(inputString);

        //then
        assertThat(start).isEqualTo(START_CODE);
    }

    @Test
    @DisplayName("2 입력")
    void inputString_2() {
        //given
        String inputString = "2";

        //when
        StatusCode exit = StatusCode.from(inputString);

        //then
        assertThat(exit).isEqualTo(EXIT_CODE);
    }

    @Test
    @DisplayName("문자 입력 예외")
    void inputNumberFormatException() {
        //given
        String inputString = "asdf";

        //when then
        assertThatThrownBy(() -> StatusCode.from(inputString))
                .isInstanceOf(InvalidStatusCodeException.class)
                .hasMessage("1 또는 2을 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("입력 코드 예외 - 3")
    void InvalidStatusCodeException_case1() {
        //given
        String inputString = "3";

        //when then
        assertThatThrownBy(() -> StatusCode.from(inputString))
                .isInstanceOf(InvalidStatusCodeException.class)
                .hasMessage("1 또는 2을 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("입력 코드 예외 - 01")
    void InvalidStatusCodeException_case2() {
        //given
        String inputString = "01";

        //when then
        assertThatThrownBy(() -> StatusCode.from(inputString))
                .isInstanceOf(InvalidStatusCodeException.class)
                .hasMessage("1 또는 2을 입력해주세요. 입력 문자: " + inputString);
    }
}