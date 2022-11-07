package baseball.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {

    @Nested
    @DisplayName("inputNumber 메서드는")
    class DescribeInputNumber {
        @Test
        @DisplayName("사용자의 입력을 반환한다.")
        void userInputNumber() {
            String expectedInputNumber = "123";

            InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
            System.setIn(in);

            ConsoleInput input = new ConsoleInput();
            String actualInputNumber = input.inputNumber();

            Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);
        }
    }
}
