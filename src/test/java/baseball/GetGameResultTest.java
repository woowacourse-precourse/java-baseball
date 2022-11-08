package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GetGameResultTest {

    @Test
    void countStrike() {
        List<Integer> user1 = new ArrayList<>(Arrays.asList(3, 4, 5));
        List<Integer> user2 = new ArrayList<>(Arrays.asList(3, 4, 7));
        List<Integer> user3 = new ArrayList<>(Arrays.asList(3, 9, 4));
        List<Integer> user4 = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> computer = new ArrayList<>(Arrays.asList(3, 4, 5));

        assertThat(GetGameResult.countStrike(user1, computer)).isEqualTo(3);
        assertThat(GetGameResult.countStrike(user2, computer)).isEqualTo(2);
        assertThat(GetGameResult.countStrike(user3, computer)).isEqualTo(1);
        assertThat(GetGameResult.countStrike(user4, computer)).isEqualTo(0);
    }

    @Test
    void countBall() {
        List<Integer> user1 = new ArrayList<>(Arrays.asList(3, 4, 5));
        List<Integer> user2 = new ArrayList<>(Arrays.asList(8, 3, 7));
        List<Integer> user3 = new ArrayList<>(Arrays.asList(4, 1, 3));
        List<Integer> user4 = new ArrayList<>(Arrays.asList(5, 3, 4));
        List<Integer> computer = new ArrayList<>(Arrays.asList(3, 4, 5));

        assertThat(GetGameResult.countBall(user1, computer)).isEqualTo(0);
        assertThat(GetGameResult.countBall(user2, computer)).isEqualTo(1);
        assertThat(GetGameResult.countBall(user3, computer)).isEqualTo(2);
        assertThat(GetGameResult.countBall(user4, computer)).isEqualTo(3);
    }
}