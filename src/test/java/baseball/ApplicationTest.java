package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
        @Nested
    class generateTest {
        @Test
        void 랜덤_숫자_테스트1_3자리_확인() {
            List<Integer> random = Application.generate();
            assertThat(random.size()).isEqualTo(3);
        }

        @Test
        void 랜덤_숫자_테스트2_숫자_범위_확인() {
            List<Integer> random = Application.generate();
            for (int i = 0; i < random.size(); i++) {
                assertThat(random.get(i)).isBetween(0, 9);
            }
        }
        @Test
        void 랜덤_숫자_테스트2_중복_숫자() {
            List<Integer> random = Application.generate();
            Set<Integer> randomNumSet = new HashSet<>(random);
            Assertions.assertThat(random.size()).isSameAs(randomNumSet.size());
        }
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
