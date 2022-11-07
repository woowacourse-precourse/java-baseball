package baseball;

import baseball.input.ConsoleInputReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class ConsoleInputReaderTest {

  private final InputStream standardIn = System.in;
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
    System.setIn(standardIn);
  }

  private static InputStream generateUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

  @Test
  void 콘솔_입력시_메시지_출력() {
    System.setIn(generateUserInput("123"));

    new ConsoleInputReader().readLine();

    assertThat(outputStreamCaptor.toString()).isEqualTo("숫자를 입력해주세요 : ");
  }
}
