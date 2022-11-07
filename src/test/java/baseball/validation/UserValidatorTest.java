package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    @DisplayName("User는 restart 를 하기 위해서 1 또는 2 숫자만 입력할 수 있습니다.")
    void testRestartNumberOnlyOneOrTwo() throws Exception {

        //when & then
        assertTrue(UserValidator.restartValidation("1"));
        assertTrue(UserValidator.restartValidation("2"));
        assertFalse(UserValidator.restartValidation("김"));
        assertFalse(UserValidator.restartValidation("24"));
        assertFalse(UserValidator.restartValidation("0"));
    }

}