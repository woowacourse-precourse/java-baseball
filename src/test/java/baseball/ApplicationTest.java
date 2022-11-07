package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.AbstractObjectArrayAssert;
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
    class generateNumTest {
        @Test
        void 랜덤_숫자_테스트1_3자리_확인() {
            List<Integer> random = Application.generateNum();
            assertThat(random.size()).isEqualTo(3);
        }

        @Test
        void 랜덤_숫자_테스트2_숫자_범위_확인() {
            List<Integer> random = Application.generateNum();
            for (int i = 0; i < random.size(); i++) {
                assertThat(random.get(i)).isBetween(0, 9);
            }
        }

        @Test
        void 랜덤_숫자_테스트3_중복_숫자_확인() {
            List<Integer> random = Application.generateNum();
            Set<Integer> randomNumSet = new HashSet<>(random);
            Assertions.assertThat(random.size()).isSameAs(randomNumSet.size());
        }
    }

    @Nested
    class inputNumTest {

    }
    @Nested
    class checkNumbersTest{
        @Test
        void 체크_넘버즈_스트라이크_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(1, 2, 3);
            Assertions.assertThat(Application.checkNumbers(computerTest,userTest)).isEqualTo("3스트라이크");
        }
        @Test
        void 체크_넘버즈_볼_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(2, 3, 1);
            Assertions.assertThat(Application.checkNumbers(computerTest,userTest)).isEqualTo("3볼");
        }
        @Test
        void 체크_넘버즈_볼_스트라이크_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(2, 1, 3);
            Assertions.assertThat(Application.checkNumbers(computerTest,userTest)).isEqualTo("2볼 1스트라이크");
        }
        @Test
        void 체크_넘버즈_낫싱_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(4, 5, 6);
            Assertions.assertThat(Application.checkNumbers(computerTest,userTest)).isEqualTo("낫싱");
        }


    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
