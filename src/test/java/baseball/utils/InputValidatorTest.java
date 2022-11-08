package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 유효성_검사_테스트() {
        List<Integer> validNum = new ArrayList<>(List.of(1, 2, 3));
        Assertions.assertThatCode(() -> InputValidator.hasValidInput(validNum))
                .doesNotThrowAnyException();

        String rangeErrorMessage = "각 자리 수는 최소 1 이상, 최대 9 이하의 정수여야 합니다.";
        String lengthErrorMessage = "숫자는 세 자리 수여야 합니다.";
        String duplicateErrorMessage = "숫자는 중복되어서는 안됩니다.";
        String typeErrorMessage = "숫자만 입력 가능합니다.";

        List<Integer> invalidRangeNum = new ArrayList<>(List.of(369, 1, 2));
        assertThatThrownBy(() -> InputValidator.hasValidInput(invalidRangeNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(rangeErrorMessage);

        List<Integer> invalidLengthNum = new ArrayList<>(List.of(1, 2));
        assertThatThrownBy(() -> InputValidator.hasValidInput(invalidLengthNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(lengthErrorMessage);

        List<Integer> duplicateNum = new ArrayList<>(List.of(1, 2, 2));
        assertThatThrownBy(() -> InputValidator.hasValidInput(duplicateNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(duplicateErrorMessage);

        String typeErrorStr = "안123";
        assertThatThrownBy(() -> InputValidator.hasValidType(typeErrorStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(typeErrorMessage);

    }

}
