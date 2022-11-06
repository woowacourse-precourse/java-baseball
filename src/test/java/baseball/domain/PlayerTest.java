package baseball.domain;

import baseball.util.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    Player player = new Player();

    @DisplayName("convertInput는 문자열의 각 문자를 정수리스트로 변환한다")
    @Test
    void convertStringToIntegerList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(9);
        assertThat(player.convertInput("159")).isEqualTo(list);
    }

    @DisplayName("checkInput 메서드는")
    @Nested
    class InputValidationTest {

        @DisplayName("문자열 길이가 정해진 자릿수와 다르면 예외가 발생한다")
        @Test
        void throwPrescribedDigitsException() {
            assertThatThrownBy(() -> player.checkInput("1234"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Number.PRESCRIBED_DIGITS + "자리 숫자");

            assertThatThrownBy(() -> player.checkInput("12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Number.PRESCRIBED_DIGITS + "자리 숫자");
        }

        @DisplayName("모두 숫자가 아니면 예외가 발생한다")
        @Test
        void throwNotNumberException() {
            assertThatThrownBy(() -> player.checkInput("1_3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("문자가 아닌 숫자");

            assertThatThrownBy(() -> player.checkInput(" 12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("문자가 아닌 숫자");
        }

        @DisplayName("0이 있으면 예외가 발생한다")
        @Test
        void throwZeroException() {
            assertThatThrownBy(() -> player.checkInput("120"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1부터 9사이의 숫자");
        }

        @DisplayName("중복된 숫자가 있으면 예외가 발생한다")
        @Test
        void throwDuplicationException() {
            assertThatThrownBy(() -> player.checkInput("111"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("서로 다른 숫자");

            assertThatThrownBy(() -> player.checkInput("212"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("서로 다른 숫자");
        }
    }
}
