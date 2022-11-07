package baseball.console;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.GameResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final ConsoleOutput output = new ConsoleOutput();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void 게임_시작_메시지_출력() {
    output.printStartMessage();
    String startMessage = "숫자 야구 게임을 시작합니다.\n";
    assertThat(outputStreamCaptor.toString()).isEqualTo(startMessage);
  }

  @Test
  void 게임종료_메시지출력() {
    output.printEndMessage();
    String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    assertThat(outputStreamCaptor.toString()).isEqualTo(endMessage);
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Nested
  class PrintResultTest {

    @Test
    void 스트라이크_결과_출력() {
      int givenStrikeCount = 1;
      int givenBallCount = 0;
      String expectedMessage = givenStrikeCount + "스트라이크\n";
      GameResult givenResult = new GameResult(givenStrikeCount, givenBallCount);
      output.printResult(givenResult);

      assertThat(outputStreamCaptor.toString()).isEqualTo(expectedMessage);
    }

    @Test
    void 볼_결과_출력() {
      int givenStrikeCount = 0;
      int givenBallCount = 1;
      String expectedMessage = givenBallCount + "볼\n";
      GameResult givenResult = new GameResult(givenStrikeCount, givenBallCount);
      output.printResult(givenResult);

      assertThat(outputStreamCaptor.toString()).isEqualTo(expectedMessage);
    }

    @Test
    void 낫싱_결과출력() {
      int givenStrikeCount = 0;
      int givenBallCount = 0;
      String expectedMessage = "낫싱\n";
      GameResult givenResult = new GameResult(givenStrikeCount, givenBallCount);
      output.printResult(givenResult);

      assertThat(outputStreamCaptor.toString()).isEqualTo(expectedMessage);
    }

    @Test
    void 스트라이크와_볼_결과출력() {
      int givenStrikeCount = 2;
      int givenBallCount = 1;
      String expectedMessage = givenBallCount + "볼 " + givenStrikeCount + "스트라이크\n";
      GameResult givenResult = new GameResult(givenStrikeCount, givenBallCount);
      output.printResult(givenResult);

      assertThat(outputStreamCaptor.toString()).isEqualTo(expectedMessage);
    }
  }
}