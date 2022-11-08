package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputTest {
    Input input;
    @BeforeEach
    public void init() {
        input = new Input();
    }

    @DisplayName("사용자 입력값의 길이가 3인지 테스트")
    @Test
    void inputNumberSizeThree() {
        String userNumber = "123";
        assertThat(input.isNumberSizeThree(userNumber)).isTrue();
    }

    @DisplayName("사용자 입력값의 길이가 3이 아닌 경우 테스트")
    @Test
    void inputNumberSizeNotThree() {
        String userNumber = "1234";
        assertThat(input.isNumberSizeThree(userNumber)).isFalse();
    }

    @DisplayName("사용자 입력값의 각 자리 숫자가 모두 다른지 테스트")
    @Test
    void inputNumberDifferent() {
        String userNumber = "123";
        assertThat(input.isNumberDifferent(userNumber)).isTrue();
    }

    @DisplayName("사용자 입력값의 각 자리 숫자 중복이 있는 경우 테스트")
    @Test
    void inputNumberDuplicate() {
        String userNumber = "122";
        assertThat(input.isNumberDifferent(userNumber)).isFalse();
    }

    @DisplayName("사용자 입력값의 각 자리 숫자의 범위가 1~9인지 테스트")
    @Test
    void inputNumberRangeValid() {
        String userNumber = "123";
        assertThat(input.isNumberRangeValid(userNumber)).isTrue();
    }

    @DisplayName("사용자 입력값의 각 자리 숫자의 범위가 1~9가 아닌 경우 테스트")
    @Test
    void inputNumberRangeInValid() {
        String userNumber = "120";
        assertThat(input.isNumberRangeValid(userNumber)).isFalse();
    }

    @DisplayName("사용자 입력값이 모두 숫자인지 테스트")
    @Test
    void inputNumberIsNumber() {
        String userNumber = "123";
        assertThat(input.isNumber(userNumber)).isTrue();
    }

    @DisplayName("사용자 입력값 중 숫자가 아닌 경우 테스트")
    @Test
    void inputNumberIsNotNumber() {
        String userNumber = "12aa";
        assertThat(input.isNumber(userNumber)).isFalse();
    }


    @DisplayName("사용자 입력 숫자 예외 처리 테스트")
    @Test
    void inputNumberValid() {
        String userNumber = "12aa";
        assertThatIllegalArgumentException().isThrownBy(() -> input.inputUserNumberValid(userNumber));
    }

    @DisplayName("재시작 여부를 위한 입력 숫자 예외 처리 테스트")
    @Test
    void inputRestartOrExitNumberValid() {
        String inputNumber = "33";
        assertThatIllegalArgumentException().isThrownBy(() -> input.inputRestartOrExitNumberValid(inputNumber));
    }

    @DisplayName("사용자 입력값인 문자열 List로 변환 테스트")
    @Test
    void inputUserNumberToList() {
        String userNumber = "123";

        List<Integer> userNumbers = input.inputToList(userNumber);
        List<Integer> result = List.of(1, 2, 3);

        assertThat(userNumbers).isEqualTo(result);
    }
}