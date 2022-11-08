package baseball.utils;

import static baseball.BaseballGame.INPUT_SIZE;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    public void validateBallNumberStringSuccessTest() throws Exception {
        // given
        String input = "123";

        // when

        // then
        assertThatCode(() -> inputValidator.validateBallNumberString(input)).doesNotThrowAnyException();
    }

    @Test
    public void validateBallNumberStringRangeFailTest() throws Exception {
        // given
        String input = "12a";

        // when

        // then
        assertThatCode(() -> inputValidator.validateBallNumberString(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("입력이 [0, 9]사이의 숫자 이외의 문자를 포함합니다.");
    }

    @Test
    public void validateBallNumberStringLengthFailTest() throws Exception {
        // given
        String input = "12";

        // when

        // then
        assertThatCode(() -> inputValidator.validateBallNumberString(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(String.format("입력한 숫자의 길이가 %d이 아닙니다.", INPUT_SIZE));
    }

    @Test
    public void validateBallNumberDuplicatedFailTest() throws Exception {
        // given
        String input = "122";

        // when

        // then
        assertThatCode(() -> inputValidator.validateBallNumberString(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("입력한 숫자에 중복이 발생했습니다.");
    }
}
