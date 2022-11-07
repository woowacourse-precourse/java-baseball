package baseball.console;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @DisplayName("게임 시작 메시지 출력")
  @Test
  void printStartMessage(){
    ConsoleOutput output = new ConsoleOutput();
    output.printStartMessage();
    String startMessage = "숫자 야구 게임을 시작합니다.\n";
    assertEquals(startMessage, outputStreamCaptor.toString());
  }
}