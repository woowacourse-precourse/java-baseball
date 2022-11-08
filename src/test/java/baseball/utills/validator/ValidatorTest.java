package baseball.utills.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    public void validateUserInput_메서드_사용시_입력문자의_길이가_3이_아닌_경우_예외_테스트() {
        String userInput = "12";

        Assertions.assertThatThrownBy(() -> Validator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void validateUserInput_메서드_사용시_입력문자가_중복된_경우_예외_테스트() {
        String userInput = "112";

        Assertions.assertThatThrownBy(() -> Validator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateUserInput_메서드_사용시_입력문자가_숫자가_아닌_경우_예외_테스트() {
        String userInput ="12a";

        Assertions.assertThatThrownBy(() -> Validator.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateOneOrTwo_메서드_사용시_입력문자의_길이가_1이_아닌_경우_예외_테스트() {
        String userInput = "12";

        Assertions.assertThatThrownBy(() -> Validator.validateOneOrTwo(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateOneOrTwo_메서드_사용시_입력문자가_1_또는_2가_아닌_경우_예외_테스트() {
        String userInput = "3";

        Assertions.assertThatThrownBy(() -> Validator.validateOneOrTwo(userInput))
                .isInstanceOf(IllegalArgumentException.class);

    }
}