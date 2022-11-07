package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        @Test
        void 입력_숫자_중복_예외() {
            assertThatThrownBy(() -> Application.inputNum("699"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력_숫자_숫자_이외값_예외() {
            assertThatThrownBy(() -> Application.inputNum("다"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력_숫자_범위_예외() {
            assertThatThrownBy(() -> Application.inputNum("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력_숫자_0숫자_예외() {
            assertThatThrownBy(() -> Application.inputNum("071"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class checkNumbersTest {
        @Test
        void 체크_넘버즈_스트라이크_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(1, 2, 3);
            Assertions.assertThat(Application.checkNumbers(computerTest, userTest)).isEqualTo("3스트라이크");
        }

        @Test
        void 체크_넘버즈_볼_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(2, 3, 1);
            Assertions.assertThat(Application.checkNumbers(computerTest, userTest)).isEqualTo("3볼");
        }

        @Test
        void 체크_넘버즈_볼_스트라이크_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(2, 1, 3);
            Assertions.assertThat(Application.checkNumbers(computerTest, userTest)).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void 체크_넘버즈_낫싱_테스트() {
            List<Integer> computerTest = Arrays.asList(1, 2, 3);
            List<Integer> userTest = Arrays.asList(4, 5, 6);
            Assertions.assertThat(Application.checkNumbers(computerTest, userTest)).isEqualTo("낫싱");
        }
    }

    @Nested
    class finishTest {
        @Test
        void 입력_0_예외() {
            assertThatThrownBy(() -> Application.finish("3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력_숫자_이외값_예외() {
            assertThatThrownBy(() -> Application.finish("다"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class mainTest {
        @Test
        void 게임종료_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    }, 1, 3, 5, 5, 8, 9
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
