package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {

    final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public static final int SIZE_OF_NUMBERS = 3;

    @Test
    @DisplayName("랜덤으로 선택한 숫자의 길이가 적합한지 테스트")
    void checkRandomNumbersSize() {
        assertThat(randomNumberGenerator.generate().size()).isEqualTo(SIZE_OF_NUMBERS);
    }

    @Test
    @DisplayName("랜덤으로 선택한 숫자들의 중복값 존재 여부 테스트")
    void checkRandomNumbersDuplication() {
        assertEquals(SIZE_OF_NUMBERS, randomNumberGenerator.generate()
                .stream()
                .distinct()
                .count());
    }
}
