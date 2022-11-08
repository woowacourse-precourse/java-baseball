package baseball;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class ContinueOrStopTest {

  @Test
  void choice() {
    String testCase1 = "a";
    String testCase2 = "12";
    String testCase3 = "11";
    String testCase4 = "22";
    String testCase5 = "3";
    Assertions.assertThat(ContinueOrStop.choice("1")).isEqualTo(true);
    Assertions.assertThat(ContinueOrStop.choice("2")).isEqualTo(false);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase1))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase2))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase3))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase4))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase5))
            .isInstanceOf(IllegalArgumentException.class);
  }


}