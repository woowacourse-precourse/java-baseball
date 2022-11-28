package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNumberGeneratorTest {
    NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 선택한다")
    @Test
    void generateRandomNumberTest() {
        List<Integer> actual = randomNumberGenerator.generate();

        assertThat(actual)
                .hasSize(3)
                .doesNotHaveDuplicates();

        actual.forEach(
                number -> assertThat(number).isBetween(1, 9)
        );
    }
}
