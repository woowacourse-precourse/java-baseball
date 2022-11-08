package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class RandomNumberTest {
  @Test
  void RandomNumbersSizeTest() {
    List<Integer> randomValues = RandomNumber.makeRandomNumber();

    assertThat(randomValues.size()).isEqualTo(3);
  }
}