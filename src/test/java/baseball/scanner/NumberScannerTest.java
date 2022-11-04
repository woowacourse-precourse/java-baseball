package baseball.scanner;

import baseball.view.scanner.NumberScanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberScannerTest {

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final NumberScanner numberScanner = new NumberScanner();

    @Test
    void 숫자를_입력한다() {
        String inputValue = "123";
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThat(numberScanner.inputNumber()).isEqualTo(inputValue);
    }

    @ParameterizedTest(name = "숫자가_아닌_것을_입력한다")
    @ValueSource(strings = {"ㅎㅇ", "", "hi", "^^"})
    void 숫자가_아닌_것을_입력한다(String inputValue) {
        InputStream inputStream = getInputStream(inputValue);
        System.setIn(inputStream);

        assertThatThrownBy(numberScanner::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }
}