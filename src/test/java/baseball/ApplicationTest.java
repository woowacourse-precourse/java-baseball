package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    class NumberControllerTest {
        @Test
        void getUniqueThreeNumbersHaveValidLength() {
            final int length = 3;
            List<Integer> result = NumberController.getUniqueThreeNumbers();
            assertThat(result.size()).isEqualTo(length);
        }

        @Test
        void getUniqueThreeNumbersIsUnique() {
            int[] oneToNine = new int[10];
            Arrays.setAll(oneToNine, i -> 1);
            oneToNine[0] = 0;
            List<Integer> result = NumberController.getUniqueThreeNumbers();
            for (int num : result) {
                oneToNine[num]--;
                assertThat(oneToNine[num] == 0).isTrue();
            }
        }
    }

    @Nested
    class InputControllerTest {

        @Test
        void checkThreeNumNotInt() {
            String input = "fdgml";
            assertThatThrownBy(() -> InputController.checkThreeNum(input)).isInstanceOf(IllegalAccessError.class);
        }

        @Test
        void checkThreeNumNoInput() {
            String input = "";
            assertThatThrownBy(() -> InputController.checkThreeNum(input)).isInstanceOf(IllegalAccessError.class);
        }

        @Test
        void checkThreeNumNotInRange() {
            String input = "301";
            assertThatThrownBy(() -> InputController.checkThreeNum(input)).isInstanceOf(IllegalAccessError.class);
        }

        @Test
        void checkThreeNumLengthOver() {
            String input = "1234";
            assertThatThrownBy(() -> InputController.checkThreeNum(input)).isInstanceOf(IllegalAccessError.class);
        }

        @Test
        void checkThreeNumDuplicate() {
            String input = "221";
            assertThatThrownBy(() -> InputController.checkThreeNum(input)).isInstanceOf(IllegalAccessError.class);
        }
    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
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
