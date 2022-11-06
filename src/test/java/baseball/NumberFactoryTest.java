package baseball;

import baseball.game.utils.NumberFactory;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberFactoryTest {

    @Test
    void createRandomNumbers_메서드_사용시_숫자3개를_받음() {
        List<Integer> numbers = NumberFactory.createRandomNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }
}
