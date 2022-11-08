package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberTest {

    @Test
    void case1_인덱스와_같은_BASEBALLNUMBER_확인() {
        int index = 1;
        int input = 1;
        int resultValue = 1;
        BaseballNumber baseballNumber = new BaseballNumber(String.valueOf(resultValue), index);
        assertThat(baseballNumber.getBaseballNumber(input))
                .isEqualTo(resultValue);
    }

    @Test
    void case2_인덱스와_다른_BASEBALLNUMBER_오류_확인() {
        int index = 1;
        int input = 2;
        int resultValue = 1;
        BaseballNumber baseballNumber = new BaseballNumber(String.valueOf(resultValue), index);
        assertThatThrownBy(() -> baseballNumber.getBaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
