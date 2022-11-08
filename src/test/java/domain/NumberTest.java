package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void 입력_값이_길이가_3_이상이면_예외처리() {
        List<Integer> numberList = List.of(1, 2, 3, 4);

        assertThatThrownBy(() -> new Number(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 세 자리 자연수여야 합니다.");
    }

    @Test
    void 입력_값에_0이_있으면_예외처리() {
        List<Integer> numberList = List.of(6, 0, 2);

        assertThatThrownBy(() -> new Number(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자리 수는 0이 아닌 자연수여야 합니다.");
    }

    @Test
    void 각_자리_수가_중복되면_예외처리() {
        List<Integer> numberList = List.of(6, 6, 2);

        assertThatThrownBy(() -> new Number(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자리 수는 서로 다른 숫자여야 합니다.");
    }
}
