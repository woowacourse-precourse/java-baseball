package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumTest {

    @Test
    void generatedNumber_isNotZero() {
        BaseballNum baseballNum = new BaseballNum();
        int first = baseballNum.getFirst();
        int second = baseballNum.getSecond();
        int third = baseballNum.getThird();

        assertThat(first).isNotEqualTo(0);
        assertThat(second).isNotEqualTo(0);
        assertThat(third).isNotEqualTo(0);
    }

    @Test
    void generatedNumber_noDuplicates() {
        BaseballNum baseballNum = new BaseballNum();
        int first = baseballNum.getFirst();
        int second = baseballNum.getSecond();
        int third = baseballNum.getThird();

        assertThat(first).isNotEqualTo(second);
        assertThat(first).isNotEqualTo(third);
        assertThat(second).isNotEqualTo(third);
    }

    @Test
    void getIndex_bound_test() {
        BaseballNum baseballNum = new BaseballNum();
        assertThat(baseballNum.getIndex(-1)).isEqualTo(0);
        assertThat(baseballNum.getIndex(14)).isEqualTo(0);
    }

    @Test
    void getIndex_isEqualTo_number() {
        BaseballNum baseballNum = new BaseballNum();
        for (int i = 1 ; i <= 9; i++) {
            int idx = baseballNum.getIndex(i);
            if (idx == 1)
                assertThat(i).isEqualTo(baseballNum.getFirst());
            else if (idx == 2)
                assertThat(i).isEqualTo(baseballNum.getSecond());
            else if (idx == 3)
                assertThat(i).isEqualTo(baseballNum.getThird());
        }
    }

    @Test
    void illegalInputError_digits() {
        assertThatThrownBy(() -> new BaseballNum(1234))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(21))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void illegalInputError_negative() {
        assertThatThrownBy(() -> new BaseballNum(-123))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(-51))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void illegalInputError_duplication() {
        assertThatThrownBy(() -> new BaseballNum(343))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(444))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNum(611))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
