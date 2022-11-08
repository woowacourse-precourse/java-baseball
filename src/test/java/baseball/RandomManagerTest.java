package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RandomManagerTest {

    @Nested
    @DisplayName("getDistinctIntegersInRange 메서드는")
    class describe_splitIntegerIntoIntegerArray {

        @Nested
        @DisplayName("[start,end]범위 내의 겹치지 않는 수 count개를")
        class describe_argumentsOfMethod extends NsTest {

            @Test
            @DisplayName("배열에 담아 반환한다.")
            void it_parse_integer_into_integerArray() {
                assertRandomNumberInRangeTest(() -> {
                    run("246", "135");
                    Assertions.assertThat(RandomManager.getDistinctIntegersInRange(1, 9, 3))
                            .isEqualTo(Arrays.array(1, 3, 5));

                    Assertions.assertThat(RandomManager.getDistinctIntegersInRange(1, 9, 1))
                            .isEqualTo(Arrays.array(1));

                    Assertions.assertThat(RandomManager.getDistinctIntegersInRange(1, 9, 3))
                            .isEqualTo(Arrays.array(1, 2, 3));
                }, 1, 3, 5, 1, 1, 1, 2, 3);
            }

            @Override
            protected void runMain() {
                IOManagerMain();
            }

            void IOManagerMain() {
            }
        }


    }
}
