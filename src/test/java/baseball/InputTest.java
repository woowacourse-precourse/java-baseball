package baseball;

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
}