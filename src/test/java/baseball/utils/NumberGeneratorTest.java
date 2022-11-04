package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGeneratorTest {

    public static final int SIZE_OF_NUMBERS = 3;

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    List<Integer> numbers = randomNumberGenerator.generate();

    @Test
    @DisplayName("랜덤으로 선택한 숫자가 3자리인지 테스트")
    void checkRandomNumbersSize() {
        assertThat(numbers.size()).isEqualTo(SIZE_OF_NUMBERS);
    }

    @Test
    @DisplayName("랜덤으로 선택한 숫자들의 중복 테스트")
    void checkRandomNumbersDuplication() {
        assertEquals(SIZE_OF_NUMBERS, numbers.stream()
                .distinct()
                .count());
    }
}
