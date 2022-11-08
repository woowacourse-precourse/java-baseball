package baseball.view.scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberScannerTest {

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final NumberScanner numberScanner = new NumberScanner();

    @DisplayName("올바른 숫자를 입력하면 검증 로직을 통과하고 입력값을 반환한다")
    @Test
    void testSuccess() {
        String inputValue = "123";
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThat(numberScanner.inputNumber()).isEqualTo(inputValue);
    }

    @ParameterizedTest(name = "숫자가 아닌 것을 입력하면 예외를 던진다")
    @ValueSource(strings = {"ㅎㅇ", "hi", "", "^^"})
    void testFail(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThatThrownBy(numberScanner::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

    @ParameterizedTest(name = "1 또는 2를 입력하면 검증 로직을 통과하고 입력값을 반환한다")
    @ValueSource(strings = {"1", "2"})
    void inputOneOrTwoTestSuccess(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThat(numberScanner.inputOneOrTwo()).isEqualTo(inputValue);
    }

    @ParameterizedTest(name = "1 또는 2 이외의 숫자를 입력하면 예외를 던진다")
    @ValueSource(strings = {"3", "4"})
    void inputOneOrTwoTestFail(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThatThrownBy(numberScanner::inputOneOrTwo)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2를 입력해주세요.");
    }
}