package generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameNumberGeneratorTest {
    @Test
    @DisplayName("List<Integer>를 하나로 연결된 String으로 잘 반환하는 가?")
    void get_number_string_test() {
        List<Integer> numbers = new ArrayList<>(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        GameNumberGenerator generator = new GameNumberGenerator(numbers);
        String number = generator.getNumber();

        assertThat(number)
                .hasSize(3)
                .isInstanceOf(String.class)
                .isEqualTo("123");
    }

    @Test
    @DisplayName("게임에서 사용할 수를 잘 발생시키는 가?")
    void get_number_test() {
        GameNumberGenerator generator = new GameNumberGenerator();
        String number = generator.getNumber();
        char[] numberChars = number.toCharArray();

        assertThat(number)
                .hasSize(3)
                .containsOnlyDigits();
        for (char c : numberChars) {
            assertThat(numberChars)
                    .containsOnlyOnce(c);
        }
    }
}
