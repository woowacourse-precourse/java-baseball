package baseball.domain;

import domain.BaseballNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumberTest {
    @Test
    void FailToCreateNumberIfNumberIsNotDigit(){
        String input = "a";
        assertThatThrownBy(() -> BaseballNumber.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void FailToValidateNumberIfNumberIsZero(){
        int zero = 0;
        assertThatThrownBy(() -> BaseballNumber.valueOf(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9사이의 숫자를 입력해야합니다.");
    }

    @Test
    void FailToValidateNumberIfGivenMinus(){
        int minusInt = -1;
        assertThatThrownBy(() -> BaseballNumber.valueOf(minusInt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9사이의 숫자를 입력해야합니다.");
    }

    @Test
    void FailToValidateNumberIfGivenOver(){
        int overInt = 10;
        assertThatThrownBy(() -> BaseballNumber.valueOf(overInt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9사이의 숫자를 입력해야합니다.");
    }

    @Test
    void IsEqual(){
        int value = 1;
        BaseballNumber compareNumber = BaseballNumber.valueOf(value);
        assertThat(compareNumber).isEqualTo(BaseballNumber.valueOf(value));
    }

    @Test
    void IsNotEqual(){
        int value = 1;
        int compareValue = 2;
        BaseballNumber compareNumber = BaseballNumber.valueOf(value);
        assertThat(compareNumber).isNotEqualTo(BaseballNumber.valueOf(compareValue));
    }
}
