package study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomsTest {
    @Test
    public void pickRandomNumberInRange() {
        int startInclusive = 1;
        int endInclusive = 9;
        int pickedNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);

        assertThat(pickedNumber).isGreaterThanOrEqualTo(startInclusive)
                .isLessThanOrEqualTo(endInclusive);
    }
    @Test
    public void pickTwoUniqueRandomNumbersInRange() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 2);
        int first = numbers.get(0);
        int second = numbers.get(1);

        assertThat(first).isNotEqualTo(second);
    }
}
