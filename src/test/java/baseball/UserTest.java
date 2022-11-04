package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
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
  void inputValueTestLengthNoError1() {
    User.inputValueTest("123");
    Assertions.assertThat("123").isEqualTo(outContent.toString().trim());
//    User.inputValueTest("12a");
//    Assertions.assertThat("12a").isEqualTo(outContent.toString().trim());
  }

  @Test
  void inputValueTestLengthNoError2() {
    User.inputValueTest("123");
    Assertions.assertThat("123").isEqualTo(outContent.toString().trim());
  }

  @Test
  void inputValueTestLengthError1() {
    Assertions.assertThatThrownBy(() -> {
      User.inputValueTest("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void inputValueTestLengthError2() {
        Assertions.assertThatThrownBy(() -> {
      User.inputValueTest("1234");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}