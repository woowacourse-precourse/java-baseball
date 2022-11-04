package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
}
