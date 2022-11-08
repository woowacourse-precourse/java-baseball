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

    @Test
    public void validateWhetherSuccessTest() throws Exception {
        // given
        String input1 = "1";
        String input2 = "1";

        // when

        // then
        assertThatCode(() -> inputValidator.validateWhether(input1)).doesNotThrowAnyException();
        assertThatCode(() -> inputValidator.validateWhether(input2)).doesNotThrowAnyException();
    }

    @Test
    public void validateWhetherFailTest() throws Exception {
        // given
        String input0 = "0";
        String input12 = "12";
        String input3 = "3";

        // when

        // then
        assertThatCode(() -> inputValidator.validateWhether(input0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2을 입력해야합니다.");
        assertThatCode(() -> inputValidator.validateWhether(input12)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2을 입력해야합니다.");
        assertThatCode(() -> inputValidator.validateWhether(input3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2을 입력해야합니다.");
    }
}
