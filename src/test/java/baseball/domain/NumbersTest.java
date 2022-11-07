package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    private static final int REGULAR_NUMBERS_SIZE = 3;

    @Test
    @DisplayName("Numbers 정상 생성 시 리스트 길이는 3")
    void 리스트_길이_3() {
        List<Integer> numberList = List.of(1, 2, 3);
        Numbers numbers = new Numbers(numberList);
        assertThat(numbers.numbers.size()).isEqualTo(REGULAR_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("리스트에 중복 숫자 발견 시 IllegalArgumentException 예외 발생")
    void 중복된_숫자_예외() {
        List<Integer> numbers = List.of(1, 2, 2);
        assertThatThrownBy(
            () -> {
                new Numbers(numbers);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리스트에 숫자 4개 이상 입력 시 IllegalArgumentException 예외 발생")
    void 숫자_4개이상_예외() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        assertThatThrownBy(
            () -> {
                new Numbers(numbers);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
