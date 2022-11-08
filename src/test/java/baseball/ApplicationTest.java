package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void RandomNumbersSizeTest() {
        List<Integer> randomValues = Application.generateRandomNumber();

        assertThat(randomValues.size()).isEqualTo(3);

    }

    @Test
    void checkUserInputTest() {
        String userInput1 = "123";
        String userInput2 = "1234";
        String userInput3 = "A23";

        assertThat(Application.checkUserInput(userInput1)).isEqualTo(true);
        assertThat(Application.checkUserInput(userInput2)).isEqualTo(false);
        assertThat(Application.checkUserInput(userInput3)).isEqualTo(false);

    }

    @Test
    void userInputToIntegerListTest() {
        String userInput = "123";

        assertThat(Application.userInputStrToIntegerList(userInput)).containsExactly(1, 2, 3);
    }

    @Test
    void countStrikeTest() {
        List<Integer> computers = Arrays.asList(2, 4, 5);
        List<Integer> inputs = Arrays.asList(2, 4, 7);

        assertThat(Application.countStrike(computers, inputs)).isEqualTo(2);
    }

    @Test
    void countBallTest() {
        List<Integer> computers = Arrays.asList(2, 4, 5);
        List<Integer> inputs = Arrays.asList(5, 4, 2);

        assertThat(Application.countBall(computers, inputs)).isEqualTo(2);
    }

    @Test
    void printResultTest() {
        Application.printResult(0, 0);
        Application.printResult(1, 0);
        Application.printResult(2, 1);
        Application.printResult(3, 0);

        assertThat(output()).isEqualTo("낫싱\n1스트라이크\n1볼 2스트라이크\n3스트라이크");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
