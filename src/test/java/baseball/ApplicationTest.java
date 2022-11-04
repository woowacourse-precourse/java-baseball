package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
