package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    Number number;
    @BeforeEach
    void classNum() {
        number = new Number();
    }

    @Test
    void checkCreateRandomNumberTest() {
        number.createRandomNumber();
    }

    @Test
    void userInputTest() {
        String input = "123";
        number.userInput(input);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        assertThat(number.userInputNumber).isEqualTo(result);
    }

    @Test
    void 올바르지_않은_길이() {
        assertThrows(IllegalArgumentException.class, () -> number.userInput("1234"));
    }

    @Test
    void 숫자_이외_문자_입력() {
        assertThrows(IllegalArgumentException.class, () -> number.userInput("12A"));
    }

    @Test
    void 중복된_숫자_입력() {
        assertThrows(IllegalArgumentException.class, () -> number.userInput("122"));
    }
}
