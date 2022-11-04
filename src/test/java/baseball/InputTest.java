package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {

  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  Input inputClass;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    inputClass = new Input();
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void Input클래스의_정상적인_작동_테스트() {
    String sysIn = "123";
    inputClass.printInputString(sysIn);
    assertEquals("[1, 2, 3]", outContent.toString().trim());
  }

  @Test
  public void 입력으로_세_자릿_수가_아닌_경우() {
    String sysIn1 = "12";
    String sysIn2 = "1234";
    String sysIn3 = "12345";
    assertThatThrownBy(() -> {
      inputClass.printInputString(sysIn1);
    }).isInstanceOf((IllegalArgumentException.class));
    assertThatThrownBy(() -> {
      inputClass.printInputString(sysIn2);
    }).isInstanceOf((IllegalArgumentException.class));
    assertThatThrownBy(() -> {
      inputClass.printInputString(sysIn3);
    }).isInstanceOf((IllegalArgumentException.class));
  }
}