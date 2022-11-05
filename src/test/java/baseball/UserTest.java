package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.GameControlStatus;
import baseball.domain.ThreeDigitNum;
import baseball.io.InputControl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {

    @Nested
    @DisplayName("입력한 값이 숫자인지 검증")
    class InputControlTest {

        @Test
        void 정수입력() {
            InputControl.strToInt("123");
            InputControl.strToInt("1");
            InputControl.strToInt("0");
        }

        @Test
        void 정수아닌문자열입력() {

            assertThatThrownBy(() -> InputControl.strToInt(""))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> InputControl.strToInt("number"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> InputControl.strToInt(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력된 값이 추측할 수 형식에 맞는지 검증")
    class InputGuessedValueTest {

        @Test
        void 세자릿수_변환_검증() {
            ThreeDigitNum t1 = new ThreeDigitNum(123);
            ThreeDigitNum t2 = new ThreeDigitNum(671);
            ThreeDigitNum t3 = new ThreeDigitNum(913);

            List<Integer> l1 = List.of(1, 2, 3);
            List<Integer> l2 = List.of(6, 7, 1);
            List<Integer> l3 = List.of(9, 1, 3);

            assertThat(t1.list()).isEqualTo(l1);

            assertThat(t2.list()).isEqualTo(l2);

            assertThat(t3.list()).isEqualTo(l3);
        }

        @Test
        void 세자릿수_예외처리_검증() {
            int[] nums = {1, 2, 0, 90, 120, 991, 1234, 064};
            for (int num : nums) {

                assertThatThrownBy(() -> new ThreeDigitNum(num))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("입력된 값이 게임 제어 숫자 형식에 맞는지 검증")
    class InputGameControlValueTest {

        @Test
        void 제어숫자로_변환_검증() {
            GameControlStatus g1 = new GameControlStatus(1);
            GameControlStatus g2 = new GameControlStatus(2);

            int v1 = 1;
            int v2 = 2;

            assertThat(g1.getValue()).isEqualTo(v1);

            assertThat(g2.getValue()).isEqualTo(v2);
        }

        @Test
        void 제어숫자_예외처리_검증() {
            int[] nums = {0, -1, 3, 90, 120, 991, 441, 064};
            for (int num : nums) {

                assertThatThrownBy(() -> new GameControlStatus(num))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
        @Test
        void 재시작여부_판별_검증() {
            GameControlStatus restart = new GameControlStatus(1);
            GameControlStatus stop = new GameControlStatus(2);

            assertThat(restart.isRestart()).isEqualTo(true);
            assertThat(stop.isRestart()).isEqualTo(false);
        }
    }
}
