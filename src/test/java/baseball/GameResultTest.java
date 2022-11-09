package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {
  @DisplayName("두_숫자로_올바른_결과가_나오는가")
  @ParameterizedTest(name ="{index} {displayName} input:{0} answer:{1} ")
  @MethodSource("inputAndExpectedAnswer")
  void isReturnCorrectResult(String input, String answer) {
    // given
    GameNumber answerGameNumber = new GameNumber();
    answerGameNumber.setGameNumberByString("123");
    GameNumber inputGameNumber = new GameNumber();
    inputGameNumber.setGameNumberByString(input);

    // when
    GameResult gameResult = new GameResult();
    gameResult.setResultByGameNumber(answerGameNumber, inputGameNumber);

    // then
    assertEquals(gameResult.getResultString(), answer);
  }

  private static Stream<Arguments> inputAndExpectedAnswer() {
    return Stream.of(
            Arguments.of("456", "낫싱"),
            Arguments.of("231", "3볼 "),
            Arguments.of("132", "2볼 1스트라이크"),
            Arguments.of("123", "3스트라이크")
    );
  }
}
