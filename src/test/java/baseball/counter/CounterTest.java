package baseball.counter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @DisplayName("사용자가 입력한 숫자에 대한 스트라이크와 볼 개수를 세는데 성공한다")
    @Test
    void 사용자가_입력한_숫자에_대한_스트라이크와_볼_개수를_세는데_성공() {
        // given
        List<Integer> userNumbers = List.of(1, 3, 5);
        List<Integer> computerNumbers = List.of(5, 3, 2);
        Counter counter = new Counter();

        // when
        counter.count(userNumbers, computerNumbers);

        // then
        assertThat(counter.getStrikeCount()).isEqualTo(1);
        assertThat(counter.getBallCount()).isEqualTo(1);
    }
}