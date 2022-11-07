package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.constants.GameConstants;
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
            RandomUtil randomUtil = new RandomUtil();

            String number = String.valueOf(randomUtil.pickRandomNumber());
            assertThat(inputValueValidation.isNumber(number)).isEqualTo(true);
        }
    }

    @Nested
    class PickNumbersTest {
        @Test
        void case1() {
            RandomUtil randomUtil = new RandomUtil();
            assertThat(randomUtil.pickNumbers().stream().distinct().count())
                    .isEqualTo(GameConstants.NUMBER_LENGTH);
        }
    }

}
