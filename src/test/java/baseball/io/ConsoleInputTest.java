package baseball.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {

    @Test
    @DisplayName("사용자 콘솔 숫자 입력 테스트")
    void userInputNumber() {
        String expectedInputNumber = "123";

        InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
        System.setIn(in);

        ConsoleInput input = new ConsoleInput();
        String actualInputNumber = input.inputNumber();

        Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);
    }
}
