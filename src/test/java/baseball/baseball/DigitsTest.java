package baseball.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DigitsTest {

    @Nested
    class Validation {

        @Test
        @DisplayName("올바른 경우")
        void caseDefault() {
            List<Integer> list = List.of(1,2,3);
            new Digits(list);
        }

        @Test
        @DisplayName("숫자 개수가 3개가 아닌 경우: 4개")
        void caseCount4() {
            List<Integer> list = List.of(1,2,3,4);

            assertThatThrownBy(() -> new Digits(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자의 개수는 항상 3이여야 합니다.");
        }

        @Test
        @DisplayName("숫자 개수가 3개가 아닌 경우: 2개")
        void caseCount2() {
            List<Integer> list = List.of(1,2);

            assertThatThrownBy(() -> new Digits(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자의 개수는 항상 3이여야 합니다.");
        }

        @Test
        @DisplayName("숫자 범위 경계값 -1이 있는 경우")
        void caseContainsMinusOne() {
            List<Integer> list = List.of(1,2,-1);

            assertThatThrownBy(() -> new Digits(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자는 1~9의 값이여야 합니다.");
        }

        @Test
        @DisplayName("숫자 범위 경계값 10이 있는 경우")
        void caseContainsMinusTen() {
            List<Integer> list = List.of(1,2,10);

            assertThatThrownBy(() -> new Digits(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자는 1~9의 값이여야 합니다.");
        }

        @Test
        @DisplayName("중복된 값이 있는 경우")
        void caseContainsDuplicatedNumber() {
            List<Integer> list = List.of(1,2,1);

            assertThatThrownBy(() -> new Digits(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자들은 중복되면 안됩니다.");
        }
    }

    @Test
    @DisplayName("Digits::getList는 생성자에 주입한 것과 같아야 함.")
    void getList() {
        List<Integer> list = List.of(1,2,3);

        Digits digits = new Digits(list);
        List<Integer> digitsList = digits.getList();

        assertThat(digitsList).isEqualTo(list);
    }

    @Test
    @DisplayName("Digits::get(idx)와 생성자에 주입한 List::get(idx)값은 같아야 한다.")
    void get() {
        List<Integer> list = List.of(1,2,3);

        Digits digits = new Digits(list);

        for (int i = 0; i < list.size(); i++) {
            assertThat(digits.get(i)).isEqualTo(list.get(i));
        }
    }
}