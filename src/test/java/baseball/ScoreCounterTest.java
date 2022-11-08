package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCounterTest {

  @ParameterizedTest
  @MethodSource("provideUserInputAndExpectedStrikeCountAndBallCount")
  void 스트라이크와_볼의_갯수를_옳게_세는가(String input, int strikeCount, int ballCount) {

    // given
    ScoreCounter scoreCounter = new ScoreCounter();
    List<Integer> computerNumber = List.of(1, 2, 3);

    // when
    scoreCounter.count(computerNumber, input);

    // then
    assertEquals(scoreCounter.ballCount, ballCount);
    assertEquals(scoreCounter.strikeCount, strikeCount);
  }

  static Stream<Arguments> provideUserInputAndExpectedStrikeCountAndBallCount() {
    return Stream.of(
      // 2스트라이크 1볼은 일어날 수 없음
      Arguments.of(Integer.toString(123), 3, 0),
      Arguments.of(Integer.toString(132), 1, 2),
      Arguments.of(Integer.toString(312), 0, 3),
      Arguments.of(Integer.toString(145), 1, 0),
      Arguments.of(Integer.toString(125), 2, 0),
      Arguments.of(Integer.toString(451), 0, 1),
      Arguments.of(Integer.toString(214), 0, 2),
      Arguments.of(Integer.toString(567), 0, 0)
    );
  }
}
