package baseball;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class ContinueOrStopTest {

  @Test
  void choice() {
    Assertions.assertThat(ContinueOrStop.choice("1")).isEqualTo(true);
    Assertions.assertThat(ContinueOrStop.choice("2")).isEqualTo(false);
  }
}