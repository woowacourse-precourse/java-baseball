package study;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryTest {
    @Test
    public void 중복되지_않는_숫자_세_개_추출() {
        for (int i = 0; i < 10000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            Assertions.assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1)).isNotEqualTo(numbers.get(2));
        }
    }

    @Test
    public void pickNumberInRange_이용해_숫자_세_개_추출() {
        for (int i = 0; i < 10000; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 9, 3);
            Assertions.assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1)).isNotEqualTo(numbers.get(2));
        }
    }

    public List<Integer> pickUniqueNumbersInRange(final int startInclusive,
                                                  final int endInclusive,
                                                  final int count) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            set.add(pickNumber);
        }
        return new ArrayList<>(set);
    }
}
