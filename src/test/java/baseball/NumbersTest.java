package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    private static final int NUMBERS_SIZE = 3;

    @Test
    void createRandomNumbers_메서드_사용시_임의의_숫자_3개가_랜덤으로_생성() {
        Numbers randomNumbers = Numbers.createRandomNumbers();

        assertThat(randomNumbers.getNumbers().size()).isEqualTo(NUMBERS_SIZE);
    }

    @Test
    void validate_메서드_사용시_서로_다른_숫자가_아닐경우_예외발생() {
        Numbers numbers = new Numbers(Arrays.asList(1, 1, 2));

        assertThatThrownBy(numbers::validate)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("서로 다른 숫자를 입력해주세요.");
    }

}
