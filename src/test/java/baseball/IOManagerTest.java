package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class IOManagerTest {

    @Nested
    @DisplayName("getNextInt 메서드는")
    class describe_getNextInt extends NsTest {

        @Test
        @DisplayName("입력을 숫자로 변환 가능한 경우 숫자를 반환한다")
        void it_return_integer_when_can_parse_input() {
            assertRandomNumberInRangeTest(() -> {
                run("246", "135");
                IOManager.println("" + IOManager.getNextInt());
                Assertions.assertThat(output()).contains("246");

                IOManager.println("" + IOManager.getNextInt());
                Assertions.assertThat(output()).contains("135");
            }, 1, 3, 5);
        }

        @Override
        protected void runMain() {
            IOManagerMain();
        }

        void IOManagerMain() {
        }
    }

    @Nested
    @DisplayName("splitIntegerIntoIntegerArray 메서드는")
    class describe_splitIntegerIntoIntegerArray extends NsTest {

        @Test
        @DisplayName("입력된 숫자를 각 자리별로 쪼개 배열로 반환한다")
        void it_parse_integer_into_integerArray() {
            assertRandomNumberInRangeTest(() -> {
                run("246", "135");
                Assertions.assertThat(IOManager.splitIntegerIntoIntegerArray(IOManager.getNextInt()))
                        .isEqualTo(Arrays.array(2, 4, 6));

                Assertions.assertThat(IOManager.splitIntegerIntoIntegerArray(IOManager.getNextInt()))
                        .isEqualTo(Arrays.array(1, 3, 5));
            }, 1, 3, 5);
        }

        @Override
        protected void runMain() {
            IOManagerMain();
        }

        void IOManagerMain() {
        }
    }
}
