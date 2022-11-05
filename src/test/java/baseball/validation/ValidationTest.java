package baseball.validation;



import baseball.constant.UserInputErrorConstantString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {
    @Test
    void 길이3이아닌input() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("12"),
                UserInputErrorConstantString.LENGTH_ERROR.getStringMessage());
    }

    @Test
    void 길이3이아닌input1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("1234"),
                UserInputErrorConstantString.LENGTH_ERROR.getStringMessage());
    }

    @Test
    void 중복된숫자() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("122"),
                UserInputErrorConstantString.CONTAINS_DUPLICATE_ERROR.getStringMessage());
    }

    @Test
    void 정수값이아닌경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("12a"),
                UserInputErrorConstantString.CONTAINS_NON_INTEGER_ERROR.getStringMessage());
    }

    @Test
    void Contains0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.userBaseballInputValidation("012"),
                UserInputErrorConstantString.NOT_BETWEEN_DESIRABLE_INTERVAL_ERROR.getStringMessage());

    }
}