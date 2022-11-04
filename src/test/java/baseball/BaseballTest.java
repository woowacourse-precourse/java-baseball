package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BaseballTest {
    @Test
    void 랜덤_숫자_확인() {
        List<Integer> number = Baseball.getComputerNumber();
        Set<Integer> check = new HashSet<>(number);
        assertThat(number.size()).isEqualTo(3);
        assertThat(check.size()).isEqualTo(3);
    }

    @Test
    void 볼_개수_확인() {
        List<Integer> computer1 = List.of(1, 2, 3);
        List<Integer> user1 = List.of(3, 8, 2);
        assertThat(Baseball.getBallCount(computer1, user1)).isEqualTo(2);

        List<Integer> computer2 = List.of(1, 2, 3);
        List<Integer> user2 = List.of(9, 8, 7);
        assertThat(Baseball.getBallCount(computer2, user2)).isEqualTo(0);
    }

    @Test
    void 스트라이크_개수_확인() {
        List<Integer> computer1 = List.of(1, 2, 3);
        List<Integer> user1 = List.of(4, 2, 3);
        assertThat(Baseball.getStrikeCount(computer1, user1)).isEqualTo(2);

        List<Integer> computer2 = List.of(1, 2, 3);
        List<Integer> user2 = List.of(1, 3, 2);
        assertThat(Baseball.getStrikeCount(computer2, user2)).isEqualTo(1);
    }
}