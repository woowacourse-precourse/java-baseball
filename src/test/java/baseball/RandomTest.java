package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.InputValueValidation;
import baseball.util.RandomUtil;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RandomTest {

    @Nested
    class PickRandomNumberTest {
        @Test
        void case1() {
            InputValueValidation inputValueValidation = new InputValueValidation();
            String number = String.valueOf(RandomUtil.pickRandomNumber());
            assertThat(inputValueValidation.isNumber(number)).isEqualTo(true);
        }
    }

    @Nested
    class PickNumbersTest {
        @Test
        void case1() {
            int ballNumberLength = 3;
            assertThat(RandomUtil.pickNumbers().stream().distinct().count())
                    .isEqualTo(ballNumberLength);
        }
    }

}
