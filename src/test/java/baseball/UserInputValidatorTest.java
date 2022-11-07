package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputValidatorTest {

    UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    void validateNumber_길이가_3이_아닌_경우_오류_반환() {
        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("1234");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("192834");
        });
    }

    @Test
    void validateNumber_숫자_범위_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("120");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("053");
        });
    }

    @Test
    void validateNumber_중복된_숫자_오류발생() {
        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("233");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            userInputValidator.validateNumber("171");
        });
    }
}