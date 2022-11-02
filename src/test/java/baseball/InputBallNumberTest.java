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

    @Test
    void 숫자_1에서9가_아닌_입력() {
        String ballNumber = "a12";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber));
        String message = exception.getMessage();
        assertEquals("1~9까지의 숫자만 입력해주세요.", message);
    }

    @Test
    void 중복된_숫자_입력() {
        String ballNumber1 = "112";
        String ballNumber2 = "122";
        String ballNumber3 = "221";
        String ballNumber4 = "212";
        String ballNumber5 = "111";

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber1));
        String message1 = exception1.getMessage();
        assertEquals("중복된 숫자는 입력할 수 없습니다.", message1);

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber2));
        String message2 = exception2.getMessage();
        assertEquals("중복된 숫자는 입력할 수 없습니다.", message2);

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber3));
        String message3 = exception3.getMessage();
        assertEquals("중복된 숫자는 입력할 수 없습니다.", message3);

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber4));
        String message4 = exception4.getMessage();
        assertEquals("중복된 숫자는 입력할 수 없습니다.", message4);

        IllegalArgumentException exception5 = assertThrows(IllegalArgumentException.class,
                () -> inputBallNumber.validation(ballNumber5));
        String message5 = exception5.getMessage();
        assertEquals("중복된 숫자는 입력할 수 없습니다.", message5);
    }
}