package baseball.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UserNumberValidatorTest {

    @DisplayName("0이 포함되면 IllegalArgumentException")
    @Test
    void checkValidationUserNumber_0포함() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(0,2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @DisplayName("같은 수가 존재하면 IllegalArgumentException")
    @Test
    void checkValidationUserNumber_다른수인지() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @DisplayName("입력된 수가 3개 미만인 경우 IllegalArgumentException")
    @Test
    void checkValidationUserNumber_3개미만() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @DisplayName("입력된 수가 3개 초과인 경우 IllegalArgumentException")
    @Test
    void checkValidationUserNumber_3개초과() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

}