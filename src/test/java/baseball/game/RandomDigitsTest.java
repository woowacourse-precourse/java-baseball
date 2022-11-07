package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomDigitsTest {
    @DisplayName("생성시 랜덤값으로 초기화됨")
    @Test
    void 랜덤_생성() {
        Digits randomDigits = RandomDigits.createRandom();
        assertThat(randomDigits.size()).isEqualTo(3);
        Digit first = randomDigits.getDigitInIndex(0);
        Digit second = randomDigits.getDigitInIndex(1);
        Digit third = randomDigits.getDigitInIndex(2);

        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(third).isNotEqualTo(first);
    }
}
