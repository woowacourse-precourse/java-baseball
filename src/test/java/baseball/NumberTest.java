package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest extends NsTest {
    @RepeatedTest(5)
    @DisplayName("상대 숫자의 자릿수가 3인지 확인")
    void validateOpponentNumberDigits() {
        List<Integer> opponentNumbers = Number.getOpponentNumbersInList();
        int size = 3;
        assertThat(opponentNumbers.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("예외: 사용자의 숫자가 3개 초과인 경우")
    void exception1_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Enter a three-digit number.")
        );
    }

    @Test
    @DisplayName("예외: 사용자의 숫자가 3개 미만인 경우")
    void exception1_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Enter a three-digit number.")
        );
    }

    @Test
    @DisplayName("예외: 사용자 입력이 숫자가 아닌 문자인 경우")
    void exception2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4de"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Enter only numbers.")
        );
    }

    @Test
    @DisplayName("예외: 사용자 입력 숫자 중 0이 포함된 경우")
    void exception3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("509"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Enter only numbers from 1 to 9.")
        );
    }

    @Test
    @DisplayName("예외: 사용자가 중복된 숫자를 입력할 경우")
    void exception4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("466"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Enter 3 different numbers for each.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
