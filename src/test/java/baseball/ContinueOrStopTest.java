package baseball;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class ContinueOrStopTest {

  @Test
  void choice_throw_test_짧은_숫자가_들어온_경우() {
    String testCase1 = "3";

    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void choice_throw_test_긴_숫자가_들어온_경우() {
    String testCase2 = "12";

    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase2))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void choice_throw_test_중복된_숫자가_들어온_경우() {
    String testCase3 = "11";
    String testCase4 = "22";

    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase3))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase4))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void choice_throw_test_숫자가_아닌_경우() {
    String testCase5 = "a";

    Assertions.assertThatThrownBy(() -> ContinueOrStop.choice(testCase5))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void choice_true_false_판별() {
    Assertions.assertThat(ContinueOrStop.choice("1")).isEqualTo(true);
    Assertions.assertThat(ContinueOrStop.choice("2")).isEqualTo(false);
  }
}