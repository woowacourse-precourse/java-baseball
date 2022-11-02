package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputBallNumberTest {

    InputBallNumber inputBallNumber;

    @BeforeEach
    void init() {
        inputBallNumber = new InputBallNumber();
    }

    @Test
    void 길이_검증() {
        String ballNumber1 = "1234";
        String ballNumber2 = "12";

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber1));
        String message1 = exception1.getMessage();
        assertEquals("1~9까지의 숫자 3개를 입력해주세요.", message1);

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber2));
        String message2 = exception2.getMessage();
        assertEquals("1~9까지의 숫자 3개를 입력해주세요.", message2);
    }
}