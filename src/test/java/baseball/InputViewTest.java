package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.view.validator.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"문자열", "abc"})
    public void 문자열_입력시_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112"})
    public void 중복된_숫자_입력시_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000", "102"})
    public void 숫자_0_입력시_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "12345"})
    public void 숫자가_세자리가_아닐경우_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}

