package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserBallsInputTest {
  private UserBallsInput input;
  private static ByteArrayOutputStream outContent;
  private static PrintStream originalOut;
  @BeforeEach
  void setUp() {
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outContent));
    input = new UserBallsInput(3);
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }
  
  @Test
  void InputSuccess() {
    input.inputNumberTest("123");
    assertEquals("123", outContent.toString());
  }

}