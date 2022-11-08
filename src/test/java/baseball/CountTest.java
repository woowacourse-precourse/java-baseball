package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    @Test
    void countBall() {

        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> digitList = List.of(1, 3, 2);

        assertThat(Count.countBall(answer, digitList)).isEqualTo(2);

    }

    @Test
    void countStrike() {

        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> digitList = List.of(1, 2, 3);

        assertThat(Count.countStrike(answer, digitList)).isEqualTo(3);

    }
}