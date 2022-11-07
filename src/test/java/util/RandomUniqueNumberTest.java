package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUniqueNumberTest {

    @Test
    @DisplayName("서로 다른 3자리 수 뽑기")
    void testGetRandomNumber() {
        List<Integer> random3Numbers = RandomUniqueNumber.getRandomUniqueNumbers(3);

        assertThat(random3Numbers.size()).isEqualTo(3);
        random3Numbers.stream()
                        .map(random3Number -> assertThat(random3Numbers.contains(random3Number))
                        .isFalse());
    }
}
