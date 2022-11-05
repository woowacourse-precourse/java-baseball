package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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
  @Order(1)
  @DisplayName("Input 생성 테스트")
  void inputSuccess() {
    input.inputNumberTest("123");
    assertEquals("123", outContent.toString());
  }

  @Test
  @Order(2)
  @DisplayName("유효성 검사 테스트")
  void inputnumberValidate() {
    input.validityChecker();
  }
}