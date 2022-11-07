package baseball.game;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  void 랜덤숫자_3개생성_테스트() {
    RandomNumberGenerator generator = new RandomNumberGenerator();

    List<Integer> result = generator.generate();

    Assertions.assertThat(result.size()).isEqualTo(3);
  }
}