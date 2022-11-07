package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    private static final int NUMBERS_SIZE = 3;

    @Test
    void createRandomNumbers_메서드_사용시_임의의_숫자_3개가_랜덤으로_생성() {
        Numbers randomNumbers = Numbers.createRandomNumbers();

        assertThat(randomNumbers.getNumbers().size()).isEqualTo(NUMBERS_SIZE);
    }

    @Test
    void validate_메서드_사용시_숫자가_3개가_아닐경우_예외발생() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2));

        assertThatThrownBy(numbers::validate)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자를 " + NUMBERS_SIZE + "개 입력해주세요.");
    }

    @Test
    void validate_메서드_사용시_서로_다른_숫자가_아닐경우_예외발생() {
        Numbers numbers = new Numbers(Arrays.asList(1, 1, 2));

        assertThatThrownBy(numbers::validate)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("서로 다른 숫자를 입력해주세요.");
    }

    @Test
    void validate_메서드_사용시_1에서_9사이의_숫자가_아닐경우_예외발생() {
        Numbers numbers = new Numbers(Arrays.asList(0, 1, 2));

        assertThatThrownBy(numbers::validate)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 입력입니다. 1~9 범위의 숫자만 입력해주세요.");
    }

}
