package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.ThreeDigitNum;
import baseball.io.InputControl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {

    @Nested
    @DisplayName("입력된 값이 추측할 수 형식에 맞는지 검증")
    class InputIntTest {

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
        @Test
        void 세자릿수_변환_검증() {
            ThreeDigitNum t1 = new ThreeDigitNum(123);
            ThreeDigitNum t2 = new ThreeDigitNum(671);
            ThreeDigitNum t3 = new ThreeDigitNum(913);

            List<Integer> l1 = List.of(1,2,3);
            List<Integer> l2 = List.of(6,7,1);
            List<Integer> l3 = List.of(9,1,3);

            assertThat(t1.list()).isEqualTo(l1);

            assertThat(t2.list()).isEqualTo(l2);

            assertThat(t3.list()).isEqualTo(l3);
        }

        @Test
        void 세자릿수_예외처리_검증() {
            int[] nums = {1,2,0,90,120,991,441,064};
            for(int num: nums) {

                assertThatThrownBy(() -> new ThreeDigitNum(num))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
