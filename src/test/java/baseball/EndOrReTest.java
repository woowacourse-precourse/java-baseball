package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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

}