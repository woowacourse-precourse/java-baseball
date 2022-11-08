package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefreeTest {

  @Test
  void countStrike() {
    List<Integer> computers = Arrays.asList(2, 4, 5);
    List<Integer> inputs = Arrays.asList(2, 4, 7);

    assertThat(Refree.countStrike(computers, inputs)).isEqualTo(2);
  }

  @Test
  void countBall() {
    List<Integer> computers = Arrays.asList(2, 4, 5);
    List<Integer> inputs = Arrays.asList(5, 4, 2);

    assertThat(Refree.countBall(computers, inputs)).isEqualTo(2);

  }


}