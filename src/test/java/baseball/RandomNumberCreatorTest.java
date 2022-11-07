package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberCreatorTest {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    @Test
    void 랜덤_숫자_만들기() {
        List<Integer> randomNumbers = RandomNumberCreator.getRandomNumbers();

        int one = randomNumbers.get(0);
        int two = randomNumbers.get(1);
        int three = randomNumbers.get(2);

        assertThat(one).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        assertThat(two).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        assertThat(three).isBetween(START_INCLUSIVE, END_INCLUSIVE);
    }
}
