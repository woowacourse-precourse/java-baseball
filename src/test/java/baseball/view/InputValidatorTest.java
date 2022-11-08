package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "719"})
    void validateBaseballNumber_메서드는_만약_1과_9사이의_중복되지_않는_3자리_숫자를_입력받으면_예외가_발생하지_않는다(String givenInput) {
        InputValidator.validateBaseballNumber(givenInput);
    }

    @Test
    void validateBaseballNumber_메서드는_만약_2자리_이하의_수를_입력받으면_IllegalArgumentException_예외를_던진다() {
        final String givenInput = "21";
        assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBaseballNumber_메서드는_만약_4자리_이상의_수를_입력받으면_IllegalArgumentException_예외를_던진다() {
        final String givenInput = "2147";
        assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBaseballNumber_메서드는_만약_중복된_값이있는_3자리_숫자를_입력받으면_IllegalArgumentException_예외를_던진다() {
        final String givenInput = "211";
        assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "validateGameStatus_메서드는_만약_{0}을_입력받는_경우_예외가_발생하지_않는다")
    @ValueSource(strings = {"1", "2"})
    void validateGameStatus_메서드는_만약_1이나_2를_입력받는_경우_예외가_발생하지_않는다(String givenInput) {
        InputValidator.validateGameStatus(givenInput);
    }

    @Test
    void validateGameStatus_메서드는_만약_1이나_2가_아닌_다른값을_입력받는_경우_IllegalArgumentException_예외를_던진다() {
        final String givenInput = "3";
        assertThatThrownBy(() -> InputValidator.validateGameStatus(givenInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
