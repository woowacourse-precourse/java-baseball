package baseball.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest extends NsTest {

    @Nested
    @DisplayName("예외 테스트")
    class getValidNumberList {
        @Test
        @DisplayName("입력 크기가 3보다 작을 때")
        void 예외_테스트_1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("27"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("input has to be 3 length.")
            );
        }

        @Test
        @DisplayName("입력 크기가 3보다 클 때")
        void 예외_테스트_2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("4832"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("input has to be 3 length.")
            );
        }

        @Test
        @DisplayName("문자가 포함될 때")
        void 예외_테스트_3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12a"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("digit range is a number of from 1 to 9.")
            );
        }

        @Test
        @DisplayName("숫자 0이 포함될 때")
        void 예외_테스트_4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("120"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("digit range is a number of from 1 to 9.")
            );
        }

        @Test
        @DisplayName("숫자가 중복될 때")
        void 예외_테스트_5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("353"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("number is cannot duplicate.")
            );
        }
    }


    @Override
    public void runMain() {
        InputNumber.getValidNumberList();
    }
}
