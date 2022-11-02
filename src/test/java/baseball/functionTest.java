package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.getNumberOfStrikes;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class functionTest {

    @Test
    void 스트라이크_개수_세기_테스트() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);a.add(1);a.add(1);
        b.add(1);b.add(1);b.add(1);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(3);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(1);b.add(4);b.add(5);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(1);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(4);b.add(5);b.add(6);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(0);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(2);b.add(3);b.add(1);

        assertThat(getNumberOfStrikes(a, b)).isEqualTo(0);
    }
}
