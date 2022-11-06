package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserNumberValidatorTest {

    @Test
    void checkValidationUserNumber_0포함() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(0,2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @Test
    void checkValidationUserNumber_다른수인지() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @Test
    void checkValidationUserNumber_3개미만() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

    @Test
    void checkValidationUserNumber_3개초과() {
        List<Integer> userNumberList = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
        Assertions.assertThrows(RuntimeException.class, () -> {
            UserNumberValidator.checkValidationUserNumber(userNumberList);
        });
    }

}