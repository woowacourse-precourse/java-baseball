package baseball.console;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.GameInputNumber;
import baseball.dto.InputSignal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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

      assertThat(outputStreamCaptor.toString()).contains("숫자를 입력해주세요");
    }

    @Test
    void 숫자입력성공시_InputClass를_리턴한다() {
      String inputStr = "123";
      InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
      System.setIn(inputStream);

      GameInputNumber result = consoleInput.inputNumber();

      assertThat(result.getNumbers().size()).isEqualTo(3);
      assertThat(result.getNumbers()).contains(1, 2, 3);
    }

    @AfterEach
    public void tearDown() {
      System.setOut(standardOut);
    }
  }

  @Nested
  class InputSignalTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ConsoleInput consoleInput = new ConsoleInput();

    @BeforeEach
    public void setUp() {
      System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 신호입력전_안내메시지가_출력되어야한다() {
      String givenSignal = "1";
      InputStream inputStream = new ByteArrayInputStream(givenSignal.getBytes());
      System.setIn(inputStream);
      String INPUT_SIGNAL_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

      consoleInput.inputSignal();

      assertThat(outputStreamCaptor.toString()).contains(INPUT_SIGNAL_MESSAGE);
    }

    @Test
    void 신호입력성공시_InputSignal클래스를_리턴한다(){
      String givenSignal = "1";
      InputStream inputStream = new ByteArrayInputStream(givenSignal.getBytes());
      System.setIn(inputStream);

      InputSignal inputSignal = consoleInput.inputSignal();

      assertThat(inputSignal.getSignal()).isEqualTo(Integer.parseInt(givenSignal));
    }
    @AfterEach
    public void tearDown() {
      System.setOut(standardOut);
    }
  }
}