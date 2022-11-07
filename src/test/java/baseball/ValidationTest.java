package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void validateNumberInput_메서드_사용시_3문자_입력이_아닐_경우_예외_발생() {
        String inputWithTwoCharacters = "12";
        String inputWithFourCharacters = "1234";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateNumberInput(inputWithTwoCharacters))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNumberInput(inputWithFourCharacters))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateNumberInput_메서드_사용시_1에서_9사이의_숫자가_아닌_입력이_들어올_경우_예외_발생() {
        String inputWithZero = "012";
        String inputWithNotNumber = "a12";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateNumberInput(inputWithZero))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNumberInput(inputWithNotNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateNumberInput_메서드_사용시_3문자_입력에_중복이_있을_경우_예외_발생() {
        String inputWithDuplicatedNumber = "121";

        assertThatThrownBy(() -> Input.validateNumberInput(inputWithDuplicatedNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateOneOrTwoInput_메서드_사용시_1문자_입력이_아닐_경우_예외_발생() {
        String inputWithTwoCharacters = "12";
        String inputWithThreeCharacters = "123";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateOneOrTwoInput(inputWithTwoCharacters))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateOneOrTwoInput(inputWithThreeCharacters))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateOneOrTwoInput_메서드_사용시_1문자_입력이_1_또는_2가_아닐_경우_예외_발생() {
        String inputZero = "0";
        String inputThree = "3";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateOneOrTwoInput(inputZero))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateOneOrTwoInput(inputThree))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
