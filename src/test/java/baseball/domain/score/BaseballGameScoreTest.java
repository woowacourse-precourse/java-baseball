package baseball.domain.score;

import static baseball.domain.score.Score.BALL_ERROR_MESSAGE;
import static baseball.domain.score.Score.STRIKE_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballGameScoreTest {

  static Score referee;

  @BeforeAll
  static void score_test_init(){
    referee = new Score();
  }

  @ParameterizedTest(name = "[{index}] computer={0} user={1} strikeCount={2}")
  @MethodSource("parametersProvider1")
  @DisplayName("스트라이크일 경우에 해당 개수만큼 strikeCount가 올라갑니다.")
  @Tag("score")
  void score_strike_calculation(List<Integer> computer, List<Integer> user, Integer strikeCount){
    referee.compareTwoNumber(computer, user);
    assertEquals(strikeCount, referee.getStrikeCount(),
        () -> STRIKE_ERROR_MESSAGE);
  }

  static Stream<Arguments> parametersProvider1() {
    return Stream.of(
      arguments(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5), 1),
      arguments(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), 2),
      arguments(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3)
    );
  }

  @ParameterizedTest(name = "[{index}] computer={0} user={1} ballCount={2}")
  @MethodSource("parametersProvider2")
  @DisplayName("볼일 경우에 해당 개수만큼 ballCount가 올라갑니다.")
  @Tag("score")
  void score_ball_calculation(List<Integer> computer, List<Integer> user, Integer ballCount){
    referee.compareTwoNumber(computer, user);
    assertEquals(ballCount, referee.getBallCount(),
        () -> BALL_ERROR_MESSAGE);
  }

  static Stream<Arguments> parametersProvider2() {
    return Stream.of(
        arguments(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), 1),
        arguments(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), 2),
        arguments(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2), 3)
    );
  }
}