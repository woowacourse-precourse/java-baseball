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

    @Test
    @DisplayName("User는 숫자를 맞추기 위해 0이 아닌 서로 다른 숫자 3개를 입력할 수 있습니다.")
    void testEachDifferentNumberWithoutZero() throws Exception {

        //when & then
        assertTrue(UserValidator.inputNumberValidation("123"));
        assertTrue(UserValidator.inputNumberValidation("389"));
        assertFalse(UserValidator.inputNumberValidation("389d"));
        assertFalse(UserValidator.inputNumberValidation("122"));
        assertFalse(UserValidator.inputNumberValidation("028"));
        assertFalse(UserValidator.inputNumberValidation("1396"));
        assertFalse(UserValidator.inputNumberValidation("12"));
        assertFalse(UserValidator.inputNumberValidation("1"));
        assertFalse(UserValidator.inputNumberValidation("김현우"));
    }

}