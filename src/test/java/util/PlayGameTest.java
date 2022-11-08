package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class PlayGameTest {

    @Test
    void compare_스트라이크_볼_비교() {

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        p1.add(1);
        p1.add(2);
        p1.add(3);
        p2.add(3);
        p2.add(2);
        p2.add(1);

        int strikeCnt = 0;
        int ballCnt = 0;

        for (int index = 0; index < 3; index++) {
            if (p1.get(index).equals(p2.get(index))) {
                strikeCnt++;
                continue;
            }
            if (p2.contains(p1.get(index))) {
                ballCnt++;
            }
        }
        assertThat(strikeCnt).isEqualTo(1);
        assertThat(ballCnt).isEqualTo(2);
    }

}
