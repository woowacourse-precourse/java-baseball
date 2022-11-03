package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    @Test
    void testFunction1_case1() {
        Computer.pickNumbers();
        ArrayList<Integer> randomNumbers = Computer.getRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void testFunction1_case2() {
        Computer.pickNumbers();
        ArrayList<Integer> randomNumbers = Computer.getRandomNumbers();

        assertThat(randomNumbers).isNotEmpty();
    }

    @Test
    void testFunction1_case3() {
        Computer.pickNumbers();
        ArrayList<Integer> randomNumbers = Computer.getRandomNumbers();

        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(1));
        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(2));
        assertThat(randomNumbers.get(1)).isNotEqualTo(randomNumbers.get(2));
    }

    @Test
    void testFunction1_case4() {
        Computer.pickNumbers();
        String randomNumbers = Computer.getRandomNumbers().toString();
        String pattern = "^[1-9]*$";

        assertThat(Pattern.matches(pattern, randomNumbers)).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
