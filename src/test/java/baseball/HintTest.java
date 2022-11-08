package baseball;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

class HintTest {

  @Test
  void ballCount_계산() {
    String userNumber = "928";
    String computerNumber = "482";

    int ballScore = Hint.ballCount(computerNumber, userNumber);
    Assertions.assertThat(ballScore).isEqualTo(2);
  }

  @Test
  void strikeCount_계산() {
    String userNumber = "529";
    String computerNumber = "941";

    int strikeCount = Hint.strikeCount(computerNumber, userNumber);
    Assertions.assertThat(strikeCount).isEqualTo(0);
  }

  @Test
  void ballAndStrike_카운트_계산() {
    String userNumber ="925";
    String computerNumber ="952";
    int ballScore = Hint.ballCount(computerNumber, userNumber);
    int strikeScore = Hint.strikeCount(computerNumber, userNumber);

    Assertions.assertThat(Hint.ballAndStrike(computerNumber, userNumber))
            .isEqualTo(new int[]{2, 1});
  }
}