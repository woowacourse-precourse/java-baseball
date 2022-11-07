package study;

import baseball.Compare;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CompareTest {

    @Test
    void 전체_개수가_같은지() {
        assertThat(2).isEqualTo(Compare.countTotal(List.of(1,2,3), List.of(3,2,6)));
    }

    @Test
    void 스트라이크_개수_같은지() {
        assertThat(3).isEqualTo(Compare.countStrike(List.of(1,2,3), List.of(1,2,3)));
    }

    @Test
    void 볼_개수_같은지() {
        assertThat(1).isEqualTo(Compare.countBall(List.of(1,2,3), List.of(3,5,7)));
    }

}
