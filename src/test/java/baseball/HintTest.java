package baseball;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

class HintTest {

  @Test
  void ballCount_계산() {
    String userNumber = "123";
    String computerNumber = "123";

    int ballScore = Hint.ballCount(computerNumber, userNumber);
    Assertions.assertThat(ballScore).isEqualTo(3);
  }

  @Test
  void strikeCount_계산() {
    String userNumber = "123";
    String computerNumber = "123";

    int strikeCount = Hint.strikeCount(computerNumber, userNumber);
    Assertions.assertThat(strikeCount).isEqualTo(3);
  }

  @Test
  void ballAndStrike_카운트_계산() {
    String userNumber ="123";
    String computerNumber ="123";
    int ballScore = Hint.ballCount(computerNumber, userNumber);
    int strikeScore = Hint.strikeCount(computerNumber, userNumber);

    Assertions.assertThat(Hint.ballAndStrike(computerNumber, userNumber))
            .isEqualTo(new int[]{ballScore - strikeScore, strikeScore});
  }
}