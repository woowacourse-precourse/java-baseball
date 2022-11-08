package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class ComputerTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @ParameterizedTest
  @MethodSource("provideStrikeCountAndBallCountAndActualOutput")
  void 컴퓨터는_올바른_힌트를_출력하는가(int strikeCount, int ballCount, String actualOutput) {

    // given
    Computer computer = new Computer();

    // when
    computer.printScore(strikeCount, ballCount);

    // then
    assertEquals(outContent.toString(), actualOutput);
  }

  static Stream<Arguments> provideStrikeCountAndBallCountAndActualOutput() {
    return Stream.of(
      Arguments.of(0, 3, "3볼\n"),
      Arguments.of(1, 2, "2볼 1스트라이크\n"),
      Arguments.of(3, 0, "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
      Arguments.of(0, 1, "1볼\n"),
      Arguments.of(0, 2, "2볼\n"),
      Arguments.of(1, 0, "1스트라이크\n"),
      Arguments.of(2, 0, "2스트라이크\n"),
      Arguments.of(0, 0, "낫싱\n")
    );
  }

}
