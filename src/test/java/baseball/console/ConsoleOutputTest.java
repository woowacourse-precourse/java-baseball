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

  @Test
  void 게임종료_메시지출력(){
    output.printEndMessage();
    String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    assertThat(outputStreamCaptor.toString()).isEqualTo(endMessage);
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }
}