package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class BaseballGameUnitTest {
    @Test
    public void getResultFromCurrentInputTest() {
        System.out.println("getResultFromCurrentInputTest Result");
        // given
        String [] testUsers = new String[9];
        testUsers[0] = "279"; // 낫싱
        testUsers[1] = "486"; // 3볼
        testUsers[2] = "683"; // 2볼
        testUsers[3] = "431"; // 1볼
        testUsers[4] = "684"; // 2볼 1스트라이크
        testUsers[5] = "842"; // 1볼 1스트라이크
        testUsers[6] = "367"; // 1스트라이크
        testUsers[7] = "874"; // 2스트라이크
        testUsers[8] = "864"; // 3스트라이크

        // when
        String computer = "864";

        // then
        for (int idx = 0; idx < testUsers.length; idx++) {
            Application.countBallStrike(computer, testUsers[idx]);
        }
        // countBallStrike() 최하단의 printResult()를 주석 처리한 후 테스트 필요.

    }

    @Test
    public void getRandomIntTest() {
        System.out.println("getRandomInt Result");
        int count = 0;
        while (count < 5) {
            System.out.println(Application.getComputersValue());
            count++;
        }

    }

    @Test
    public void validateUserInputTest() {
        String[] testStrings = {"123", "504", "15", "5316", "336"};
        assertThat(Application.validateUserInput(testStrings[0])).isEqualTo("123");
        assertThrows(IllegalArgumentException.class, () -> Application.validateUserInput(testStrings[1]));
        assertThrows(IllegalArgumentException.class, () -> Application.validateUserInput(testStrings[2]));
        assertThrows(IllegalArgumentException.class, () -> Application.validateUserInput(testStrings[3]));
        assertThrows(IllegalArgumentException.class, () -> Application.validateUserInput(testStrings[4]));
    }

    @Test
    public void charAtTest() {
        String testString = "15328";
        assertThat(testString.contains("2")).isEqualTo(true);
        assertThat(testString.contains("9")).isEqualTo(false);
        assertThat(testString.charAt(0)).isEqualTo('1');
        assertThat(testString.charAt(1)).isEqualTo('5');
        assertThat(testString.charAt(2)).isEqualTo('3');
        assertThat(testString.charAt(3)).isEqualTo('2');
        assertThat(testString.charAt(4)).isEqualTo('8');

    }

}
