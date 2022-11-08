package missionutils;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class RandomTest {

    @Test
    void 랜덤_함수_테스트() throws Exception {
        //Given
        Set<Integer> range = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //When
        //Then
        for (int i = 0; i < 100_000; i++) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            Assertions.assertThat(range.contains(pickedNumber)).isTrue();
        }
    }
}
