package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    private static final int NUMBERS_SIZE = 3;

    @Test
    void createRandomNumbers_메서드_사용시_임의의_숫자_3개가_랜덤으로_생성() {
        Numbers randomNumbers = Numbers.createRandomNumbers();

        assertThat(randomNumbers.getNumbers().size()).isEqualTo(NUMBERS_SIZE);
    }

}
