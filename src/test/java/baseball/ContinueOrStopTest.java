package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ContinueOrStopTest {

  @Test
  void choice() {
    assertThat(ContinueOrStop.choice("1")).isEqualTo(true);
    assertThat(ContinueOrStop.choice("2")).isEqualTo(false);
  }
}