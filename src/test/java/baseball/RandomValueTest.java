package baseball;

import baseball.domain.RandomValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomValueTest {
    @Test
    void 랜덤값생성_확인() {
        RandomValue randomValue = new RandomValue();
        List<Integer> randomList = randomValue.getRandom();
        assertThat(randomList.size()).isEqualTo(3);
    }

}
