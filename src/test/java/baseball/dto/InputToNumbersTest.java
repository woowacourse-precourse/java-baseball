package baseball.dto;

import static org.assertj.core.api.Assertions.*;

import baseball.dto.InputToNumbers;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputToNumbersTest {

    @Test
    @DisplayName("숫자 이외의 값 입력시 예외 발생")
    void 숫자_아니면_예외() {
        assertThatThrownBy(
            () -> InputToNumbers.toNumbers("abc")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 비면 예외")
    void 입력값이_비면_예외() {
        assertThatThrownBy(
            () -> InputToNumbers.toNumbers("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 공백면 예외")
    void 입력값이_공백이면_예외() {
        assertThatThrownBy(
            () -> InputToNumbers.toNumbers(" ")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("세자리 숫자 문자열 입력시 길이 3짜리 리스트 생성")
    void 세자리_숫자_문자열_길이_3() {
        List<Integer> numbers = InputToNumbers.toNumbers("123");
        assertThat(numbers.size()).isEqualTo(3);
    }

}
