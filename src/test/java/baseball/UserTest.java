package baseball;

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
class UserTest {
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
    String returnValue = User.inputValueTestPlayingMode("123");
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(2)
  void inputValueTestLengthNoError2() {
    String returnValue = User.inputValueTestPlayingMode("123");
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(3)
  void inputValueTestLengthError1() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayingMode("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(4)
  void inputValueTestLengthError2() {
        Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayingMode("1234");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(5)
  void inputValueTestOnlyNumNoError1() {
    String returnValue = User.inputValueTestPlayingMode("123");
    Assertions.assertThat("123").isEqualTo(returnValue);
  }

  @Test
  @Order(6)
  void inputValueTestOnlyNumNoError2() {
    String returnValue = User.inputValueTestPlayingMode("124");
    Assertions.assertThat("124").isEqualTo(returnValue);
  }

  @Test
  @Order(7)
  void inputValueTestOnlyNumError1() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayingMode("120");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(8)
  void inputValueTestOnlyNumError2() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayingMode("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(8)
  void inputValueTestOnlyNumError3() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayingMode("122");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @Order(9)
  void inputValueTestPlayAgainInput() {
    String returnValue = User.inputValueTestPlayAgainMode("1");
    Assertions.assertThat("1").isEqualTo(returnValue);
  }

  @Test
  @Order(10)
  void inputValueTestPlayAgainInputError() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTestPlayAgainMode("");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}