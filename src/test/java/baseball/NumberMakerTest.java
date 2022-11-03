package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberMakerTest {
    NumberMaker numberMaker = new NumberMaker();

    @Test
    void makeNumberInRange() {
        int start = 1;
        int end = 9;
        for (int i = 0; i < 100; i++) {
            int randomNumber = numberMaker.makeNumberInRange(start, end);
            assertThat(randomNumber).isBetween(start, end);
        }
    }
}