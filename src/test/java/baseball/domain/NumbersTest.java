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

}
