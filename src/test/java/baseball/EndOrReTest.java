package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndOrReTest {

  private static ByteArrayOutputStream outContent;
  private static PrintStream originalOut;
  EndOrRe endOrRe;

  @BeforeEach
  public void setEndOrTest() {
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outContent));
    endOrRe = new EndOrRe();
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  void 입력된_값_확인1() {
    String result = "1";
    endOrRe.printInputString(result);
    assertEquals("1", outContent.toString().trim());
  }

  @Test
  void 입력된_값_확인2() {
    String result = "2";
    endOrRe.printInputString(result);
    assertEquals("2", outContent.toString().trim());
  }

  @Test
  void 입력된_값이_1과_2가_아닐_경우() {
    String result = "3";
    Assertions.assertThatThrownBy(() -> {
      endOrRe.printInputString(result);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}