package baseball;

import IOController.KeyboardInput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class KeyboardInputTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  @Order(1)
  void inputValueTestLengthNoError1() {
    String returnValue = KeyboardInput.inputValueTestByMode("123", 1);
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(2)
  void inputValueTestLengthNoError2() {
    String returnValue = KeyboardInput.inputValueTestByMode("123", 1);
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(3)
  void inputValueTestLengthError1() {
    Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("", 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(4)
  void inputValueTestLengthError2() {
        Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("1234", 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(5)
  void inputValueTestOnlyNumNoError1() {
    String returnValue = KeyboardInput.inputValueTestByMode("123", 1);
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(6)
  void inputValueTestOnlyNumNoError2() {
    String returnValue = KeyboardInput.inputValueTestByMode("124", 1);
    Assertions.assertThat("124").isEqualTo(returnValue);
  }

  @Test
  @Order(7)
  void inputValueTestOnlyNumError1() {
    Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("120", 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(8)
  void inputValueTestOnlyNumError2() {
    Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("", 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(8)
  void inputValueTestOnlyNumError3() {
    Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("122", 1);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(9)
  void inputValueTestPlayAgainInput() {
    String returnValue = KeyboardInput.inputValueTestByMode("1", 2);
    Assertions.assertThat("1").isEqualTo(returnValue);
  }

  @Test
  @Order(10)
  void inputValueTestPlayAgainInputError() {
    Assertions.assertThatThrownBy(() -> {
      KeyboardInput.inputValueTestByMode("",2);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}