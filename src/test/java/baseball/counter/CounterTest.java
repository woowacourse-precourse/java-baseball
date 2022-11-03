package baseball.counter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CounterTest {

    @Test
    void 사용자가_입력한_숫자에_대한_스트라이크와_볼_개수를_세는데_성공() {
        // given
        List<Integer> userNumbers = List.of(1, 3, 5);
        List<Integer> computerNumbers = List.of(5, 3, 2);
        Counter counter = new Counter();

        // when
        counter.count(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(counter.getStrikeCount()).isEqualTo(1);
        Assertions.assertThat(counter.getBallCount()).isEqualTo(1);
    }
}