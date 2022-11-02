package baseball.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleOutputTest {
    private static final ConsoleOutput output = new ConsoleOutput();
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restore() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("어플리케이션 시작 문구 테스트")
    void startTextWhenRunApplication() {
        output.printStartText();

        Assertions.assertThat(outputMessage.toString()).isEqualTo("숫자 야구 게임을 시작합니다.\n");
    }
}
