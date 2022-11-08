package baseball.view.scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberScannerTest {

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final NumberScanner numberScanner = new NumberScanner();

    @Test
    void 올바른_숫자를_입력하면_검증_로직을_통과하고_입력값을_반환한다() {
        String inputValue = "123";
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThat(numberScanner.inputNumber()).isEqualTo(inputValue);
    }

    @ParameterizedTest(name = "숫자가_아닌_것을_입력하면_예외를_던진다")
    @ValueSource(strings = {"ㅎㅇ", "", "hi", "^^"})
    void 숫자가_아닌_것을_입력한다(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThatThrownBy(numberScanner::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

    @ParameterizedTest(name = "1_또는_2를_입력하면_검증_로직을_통과하고_입력값을_반환한다")
    @ValueSource(strings = {"1", "2"})
    void inputOneOrTwoTestSuccess(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThat(numberScanner.inputOneOrTwo()).isEqualTo(inputValue);
    }

    @ParameterizedTest(name = "1_또는_2_이외의_숫자를_입력하면_예외를_던진다")
    @ValueSource(strings = {"3", "4"})
    void inputOneOrTwoTestFail(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThatThrownBy(numberScanner::inputOneOrTwo)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2를 입력해주세요.");
    }
}