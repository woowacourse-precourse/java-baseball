package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    @DisplayName("임의의 수를 생성한다")
    void generate_random_numbers() {
        Numbers generatedNumbers = new Computer().generateNumbers(1, 3);
        Long balls = generatedNumbers.countBallsWith(numbersOf(1, 2, 3));
        Long strikes = generatedNumbers.countStrikesWith(numbersOf(1, 2, 3));

        assertThat(balls + strikes).isEqualTo(3);
    }

    private Numbers numbersOf(Integer... numbers) {
        return new Numbers(List.of(numbers));
    }
}
