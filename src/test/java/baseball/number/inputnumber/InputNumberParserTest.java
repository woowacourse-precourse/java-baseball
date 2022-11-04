package baseball.number.inputnumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberParserTest {

    private final InputNumberParser inputNumberParser = new InputNumberParser();

    @Test
    void 세_자리_숫자_문자열을_입력받고_리스트를_반환한다() {
        String inputValue = "123";
        List<Integer> inputNumber = inputNumberParser.parseInputNumber(inputValue);

        assertThat(inputNumber.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "세_자리가_아닌_문자열을_입력받으면_예외를_던진다")
    @ValueSource(strings = {"1234", "12"})
    void 세_자리가_아닌_문자열을_입력받으면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> inputNumberParser.parseInputNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리의 숫자를 입력해 주세요.");
    }

    @Test
    void 음수를_입력하면_예외를_던진다() {
        String inputValue = "-12";

        assertThatThrownBy(() -> inputNumberParser.parseInputNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력해 주세요.");
    }

    @ParameterizedTest(name = "숫자_0을_포함하면_예외를_던진다")
    @ValueSource(strings = {"012", "120", "102"})
    void 숫자_0을_포함하면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> inputNumberParser.parseInputNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 포함될 수 없습니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest(name = "중복_숫자를_입력하면_예외를_던진다")
    @ValueSource(strings = {"112", "111"})
    void 중복_숫자를_입력하면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> inputNumberParser.parseInputNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
    }
}