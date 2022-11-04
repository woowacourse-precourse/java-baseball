package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnswerTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @Nested
  @DisplayName("Answer Class")
  class AnswerKoTest {

    @Nested
    @DisplayName("compare method is")
    class DescribeCompare {

      @Test
      @DisplayName("낫싱")
      void compareNoting() {
        Answer answer = new Answer(List.of('1', '2', '3'));
        answer.compare(new BaseBallNumber(List.of('4', '5', '6')));
        Assertions.assertThat("낫싱").isEqualTo(outContent.toString().trim());
      }
    }
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }
}
