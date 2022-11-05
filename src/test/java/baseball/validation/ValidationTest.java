package baseball.validation;

import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.UserInputErrorConstantString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {
    @Test
    void 길이3이아닌input() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("12"),
                UserInputErrorConstantString.LENGTH_ERROR.getStringValue());
    }

    @Test
    void 길이3이아닌input1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userBaseballInputValidation.userInputValidation("1234"),
                UserInputErrorConstantString.LENGTH_ERROR.getStringValue());
    }

    @Test
    void 중복된숫자() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userBaseballInputValidation.userInputValidation("122"),
                UserInputErrorConstantString.CONTAINS_DUPLICATE_ERROR.getStringValue());
    }

    @Test
    void 정수값이아닌경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userBaseballInputValidation.userInputValidation("12a"),
                UserInputErrorConstantString.CONTAINS_NON_INTEGER_ERROR.getStringValue());
    }

    @Test
    void Contains0() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidation.userInputValidation("012"),
                UserInputErrorConstantString.NOT_BETWEEN_DESIRABLE_INTERVAL_ERROR.getStringValue());

    }
}