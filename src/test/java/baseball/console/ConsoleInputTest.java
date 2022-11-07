package baseball.console;


import baseball.dto.GameInputNumber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConsoleInputTest {

  @Nested
  class InputNumberTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ConsoleInput consoleInput = new ConsoleInput();

    @BeforeEach
    public void setUp() {
      System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 숫자입력시_안내메시지가_출력된다() {
      InputStream inputStream = new ByteArrayInputStream("123".getBytes());
      System.setIn(inputStream);

      consoleInput.inputNumber();

      Assertions.assertThat(outputStreamCaptor.toString()).contains("숫자를 입력해주세요");
    }

    @Test
    void 숫자입력성공시_InputClass를_리턴한다() {
      String inputStr = "123";
      InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
      System.setIn(inputStream);

      GameInputNumber result = consoleInput.inputNumber();

      Assertions.assertThat(result.getNumbers().size()).isEqualTo(3);
      Assertions.assertThat(result.getNumbers()).contains(1, 2, 3);
    }

    @AfterEach
    public void tearDown() {
      System.setOut(standardOut);
    }
  }
}