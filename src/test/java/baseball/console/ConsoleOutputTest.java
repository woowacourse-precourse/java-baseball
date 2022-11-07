package baseball.console;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final ConsoleOutput output = new ConsoleOutput();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void 게임_시작_메시지_출력() {
    output.printStartMessage();
    String startMessage = "숫자 야구 게임을 시작합니다.\n";
    assertThat(outputStreamCaptor.toString()).isEqualTo(startMessage);
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }
}