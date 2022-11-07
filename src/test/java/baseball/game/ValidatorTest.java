package baseball.game;

import baseball.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidatorTest {
    @Test
    void 길이가_3보다_작을때_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLength("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LENGTH_EXCEPTION);
    }

    @Test
    void 길이가_3보다_클때_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLength("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LENGTH_EXCEPTION);
    }

    @Test
    void 길이가_3인경우_정상_실행() {
        Validator.validateLength("123");
        Validator.validateLength("456");
        Validator.validateLength("789");
    }

    @Test
    void 숫자가_아닌_문자가_포함된_경우_예외_발생1() {
        assertThatThrownBy(() -> Validator.validateNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ANOTHER_CHARACTER_EXCEPTION);
    }

    @Test
    void 숫자가_아닌_문자가_포함된_경우_예외_발생2() {
        assertThatThrownBy(() -> Validator.validateNumber("a12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ANOTHER_CHARACTER_EXCEPTION);
    }

    @Test
    void 숫자가_아닌_문자가_없는_경우_정상_실행() {
        Validator.validateNumber("1");
        Validator.validateNumber("12");
        Validator.validateNumber("123");
        Validator.validateNumber("1234");
    }


    @Test
    void 숫자_0을_포함하는_경우_예외_발생1() {
        assertThatThrownBy(() -> Validator.validateNonZero("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ZERO_EXCEPTION);
    }

    @Test
    void 숫자_0을_포함하는_경우_예외_발생2() {
        assertThatThrownBy(() -> Validator.validateNonZero("10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ZERO_EXCEPTION);
    }

    @Test
    void 숫자_0을_포함하지_않는_경우_정상_실행() {
        Validator.validateNonZero("1");
        Validator.validateNonZero("12");
        Validator.validateNonZero("123");
        Validator.validateNonZero("1234");
    }


    @Test
    void 중복된_숫자_포함시_예외_발생1() {
        assertThatThrownBy(() -> Validator.validateDuplicate("55"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_SAME_NUMBER_EXCEPTION);
    }

    @Test
    void 중복된_숫자_포함시_예외_발생2() {
        assertThatThrownBy(() -> Validator.validateDuplicate("33"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_SAME_NUMBER_EXCEPTION);
    }

    @Test
    void 중복된_숫자_없을때_정상_실행() {
        Validator.validateDuplicate("12");
        Validator.validateDuplicate("123");
        Validator.validateDuplicate("34");
        Validator.validateDuplicate("56");
    }


    @Test
    void 사용자_입력_종합_테스트_정상_실행() {
        Validator.validateNumberString("123");
        Validator.validateNumberString("456");
        Validator.validateNumberString("789");
    }

    @Test
    void 사용자_입력_종합_테스트_예외_발생() {
        assertThatThrownBy(() -> Validator.validateNumberString("a12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ANOTHER_CHARACTER_EXCEPTION);

        assertThatThrownBy(() -> Validator.validateNumberString("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_ZERO_EXCEPTION);

        assertThatThrownBy(() -> Validator.validateNumberString("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LENGTH_EXCEPTION);

        assertThatThrownBy(() -> Validator.validateNumberString("557"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.HAVING_SAME_NUMBER_EXCEPTION);
    }

    @Test
    void 재시작_응답_결과가_1또는_2가_아닌_경우_예외_발생1() {
        assertThatThrownBy(() -> Validator.validateRestartResponse("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.RESTART_RESPONSE_EXCEPTION);
    }

    @Test
    void 재시작_응답_결과가_1또는_2가_아닌_경우_예외_발생2() {
        assertThatThrownBy(() -> Validator.validateRestartResponse("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.RESTART_RESPONSE_EXCEPTION);
    }

    @Test
    void 재시작_응답_결과가_1또는_2인_경우_정상_실행() {
        Validator.validateRestartResponse("1");
        Validator.validateRestartResponse("2");
    }
}
