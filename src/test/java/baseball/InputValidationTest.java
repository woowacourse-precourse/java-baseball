package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputValidationTest {

    @Test
    void checkNumberValidation_메서드_사용시_3자리_입력이_아닌_경우_예외_발생() {
        String twoDigitInput = "12";
        String fourDigitInput = "1234";

        assertAll(
                () -> assertThatThrownBy(() -> InputValidation.checkNumberLength(twoDigitInput, 3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 3자리 수가 아닙니다."),
                () -> assertThatThrownBy(() -> InputValidation.checkNumberLength(fourDigitInput, 3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 3자리 수가 아닙니다.")
        );
    }

    @Test
    void checkNumberValidation_메서드_사용시_주어진_범위의_수가_아닌_경우_예외_발생() {
        Integer zeroInput = 0;
        Integer bigNumberInput = 100;

        assertAll(
                () -> assertThatThrownBy(() -> InputValidation.checkNumberRange(zeroInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 1 ~ 9 범위의 수가 아닙니다."),
                () -> assertThatThrownBy(() -> InputValidation.checkNumberRange(bigNumberInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 1 ~ 9 범위의 수가 아닙니다.")
        );
    }

    @Test
    void checkNumberValidation_메서드_사용시_중복된_수로_이루어진_경우_예외_발생() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2));
        Integer targetNumber = 2;


        assertThatThrownBy(() -> InputValidation.checkDuplicateNumber(numbers, targetNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 서로 다른 수가 아닙니다.");
    }

    @Test
    void checkGameEndChoiceNumber_메서드_사용시_1_또는_2가_아닌_경우_예외_발생() {
        String threeDigitInput = "123";
        String zeroInput = "0";

        assertAll(
                () -> assertThatThrownBy(() -> InputValidation.checkGameEndChoiceNumber(threeDigitInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 1자리 수가 아닙니다."),
                () -> assertThatThrownBy(() -> InputValidation.checkGameEndChoiceNumber(zeroInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값은 1또는 2의 값이 아닙니다.")
        );
    }
}