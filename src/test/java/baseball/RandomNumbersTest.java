package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumbersTest {
    @Test
    void 세_자리_수가_아닌_경우() {
        assertThatThrownBy(() -> new RandomNumbers(List.of(RandomNumber.valueOf(4), RandomNumber.valueOf(7), RandomNumber.valueOf(9)
                , RandomNumber.valueOf(3)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되는_수가_생성되는_경우(){
        assertThatThrownBy(() -> new RandomNumbers(List.of(RandomNumber.valueOf(2), RandomNumber.valueOf(2))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
