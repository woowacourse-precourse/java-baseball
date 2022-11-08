package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    @Test
    @DisplayName("각 자리가 숫자이면서 1과 9사이의 숫자인지")
    void isNumericTest() {
        String string1 = "135";
        boolean result1 = true;
        assertThat(isNumeric(string1)).isEqualTo(result1);
        String string2 = "1-3";
        boolean result2 = false;
        assertThat(isNumeric(string2)).isEqualTo(result2);
        String string3 = "102";
        boolean result3 = false;
        assertThat(isNumeric(string3)).isEqualTo(result3);
    }

    @Test
    @DisplayName("각 자리 숫자에 중복이 있는지")
    void isDuplicateTest() {
        String string1 = "113";
        boolean result1 = true;
        assertThat(isDuplicate(string1)).isEqualTo(result1);
        String string2 = "987";
        boolean result2 = false;
        assertThat(isDuplicate(string2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("유효하지 않은 숫자에 대해 예외 처리를 잘 하는지")
    void validateNumberExceptionTest() {
        List<String> userInputList = Arrays.asList("9873", "1121", "--1");
        for (int i = 0; i < 3; i++) {
            String userInput = userInputList.get(i);
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validateNumber(userInput));
        }
    }

    @Test
    @DisplayName("1과 2가 아닌 값을 입력했을 때 예외 처리를 잘 하는지")
    void validateRestartOrEndExceptionTest(){
        List<String> userInputList = Arrays.asList("0", "12", " ");
        for (int i = 0; i < 3; i++) {
            String userInput = userInputList.get(i);
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validateRestartOrEnd(userInput));
        }
    }

}
