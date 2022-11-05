package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();

    @Test
    void computerNumber() {
        assertThat(baseballGame.createComputerNumber()).isNotEmpty();
        assertThat(baseballGame.createComputerNumber()).doesNotContain(0);
    }

    @Test
    void isValidNumberTest() {
        List<String> testNumber = List.of("012", "102", "120", "1234", "111", "123", "abc", "972");
        List<Boolean> result = List.of(false, false, false, false, false, true, false, true);
        for (int index = 0; index < testNumber.size(); index++) {
            assertThat(baseballGame.isValidNumber(testNumber.get(index))).isEqualTo(result.get(index));
        }
    }

    @Nested
    class checkStrikeTest {
        @Test
        void case1() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            List<Integer> userNumber = List.of(1, 2, 3);
            int result = 3;
            assertThat(baseballGame.checkStrike(computerNumber, userNumber)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            List<Integer> userNumber = List.of(1, 2, 4);
            int result = 2;
            assertThat(baseballGame.checkStrike(computerNumber, userNumber)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            List<Integer> userNumber = List.of(2, 3, 5);
            int result = 0;
            assertThat(baseballGame.checkStrike(computerNumber, userNumber)).isEqualTo(result);
        }
    }
}
