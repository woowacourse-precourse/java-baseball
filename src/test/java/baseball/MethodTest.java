package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MethodTest {

    @Test
    void generateThreeDigitNumber_메서드_사용시_서로_다른_세_자리_수를_생성() {
        //given
        List<Integer> result;

        //when
        result = Application.generateThreeDigitsNumber();

        //then
        assertThat(result).isNotNull();

        assertThat(result.size()).isEqualTo(3);

        for (Integer number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(9);
        }

        Set<Integer> set = new HashSet<>(result);
        assertThat(set.size()).isEqualTo(3);

        List<Integer> temp = Application.generateThreeDigitsNumber();
        assertThat(result).isNotSameAs(temp);
    }
}