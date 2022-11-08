package baseball.game;

import baseball.controller.RandomInRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomDigitsTest {
    @DisplayName("생성시 랜덤값으로 초기화됨")
    @Test
    void 랜덤_생성() {
        RandomInRange random = new RandomInRange() {
            private int key = 1;

            @Override
            public int pickRandomInRange(int startInclusive, int endInclusive) {
                return key++;
            }
        };
        Digits randomDigits = RandomDigits.createRandom(random);
        assertThat(randomDigits.size()).isEqualTo(3);
        Digit first = randomDigits.getDigitInIndex(0);
        Digit second = randomDigits.getDigitInIndex(1);
        Digit third = randomDigits.getDigitInIndex(2);

        assertThat(first).isEqualTo(Digit.ONE);
        assertThat(second).isEqualTo(Digit.TWO);
        assertThat(third).isEqualTo(Digit.THREE);
    }
}
