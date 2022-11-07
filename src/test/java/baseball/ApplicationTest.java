package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    void 볼_스트라이크_출력_테스트() {
        ArrayList<Integer> strikesAndBalls = new ArrayList<>(Arrays.asList(2, 0));
        Application.gameResult(strikesAndBalls);

        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void 볼_스트라이크_계산_테스트() {
        ArrayList<Integer> computers = new ArrayList<>(Arrays.asList(5, 1, 9));
        ArrayList<Integer> users = new ArrayList<>(Arrays.asList(6, 1, 3));
        ArrayList<Integer> result = new ArrayList<>();

        result = Application.comparing(computers, users);

        assertThat(result).containsExactly(1,0);

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
