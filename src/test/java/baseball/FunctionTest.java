package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest {

    @Nested
    class ComputerTest {
        @Test
        @DisplayName("각 자릿수는 모두 달라야한다.")
        void test1() {
            Computer computer = new Computer();
            List<Integer> number = computer.makeComputerNumber();

            assertThat(number.get(0)).isNotEqualTo(number.get(1));
            assertThat(number.get(1)).isNotEqualTo(number.get(2));
            assertThat(number.get(2)).isNotEqualTo(number.get(0));
        }

        @Test
        @DisplayName("각 자릿수는 1~9로 이루어져 있다.")
        void test2() {
            Computer computer = new Computer();
            List<Integer> number = computer.makeComputerNumber();

            assertThat(number.get(0)).isStrictlyBetween(0, 10);
            assertThat(number.get(1)).isStrictlyBetween(0, 10);
            assertThat(number.get(2)).isStrictlyBetween(0, 10);
        }
    }

    @Nested
    class UserTest {
        @Test
        @DisplayName("조건에 하나라도 부합한다면 IllegalArgumentException 발생")
        void test1() {
            User user = new User();

            assertThatThrownBy(() -> {
                user.validateUserNumber(asList(1, 1, 2));
            }).isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> {
                user.validateUserNumber(asList(1, 0, 8));
            }).isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> {
                user.validateUserNumber(asList(1));
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("각 자릿수가 1~9로 이루어져 있는지 확인")
        void test2() {
            User user = new User();

            assertThat(user.checkRange(asList(1, 0, 2))).isFalse();
            assertThat(user.checkRange(asList(0, 0, 0))).isFalse();
            assertThat(user.checkRange(asList(1, 2, 10))).isFalse();
            assertThat(user.checkRange(asList(8, 9, 7))).isTrue();
        }

        @Test
        @DisplayName("3자릿수 인지 확인")
        void test3() {
            User user = new User();

            assertThat(user.checkLength(asList(1))).isFalse();
            assertThat(user.checkLength(asList(1, 3))).isFalse();
            assertThat(user.checkLength(asList(1, 1, 2, 3))).isFalse();
            assertThat(user.checkLength(asList(1, 2, 3))).isTrue();
        }

        @Test
        @DisplayName("각 자릿수가 모두 다른지 확인")
        void test4() {
            User user = new User();

            assertThat(user.checkEachDifferent(asList(1, 1, 2))).isFalse();
            assertThat(user.checkEachDifferent(asList(7, 2, 2))).isFalse();
            assertThat(user.checkEachDifferent(asList(1, 2, 3))).isTrue();
            assertThat(user.checkEachDifferent(asList(4, 1, 2))).isTrue();
        }
    }
}
