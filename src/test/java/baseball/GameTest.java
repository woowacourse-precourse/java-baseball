package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 게임_게임종료_후_재시작_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_낫싱_3스트라이크_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "789", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                7, 8, 9, 2
        );
    }

    @Test
    void 게임_낫싱_낫싱_0볼2스트라이크_2볼1스트라이크_3스트라이크_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "128", "321", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "0볼 2스트라이크", "2볼 1스트라이크",
                            "3스트라이크", "게임 종료");
                },
                1, 2, 3, 2
        );
    }

    @Test
    void 게임_0볼2스트라이크_3스트라이크_재시작_3스트라이크_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "123", "1", "456", "2");
                    assertThat(output()).contains("0볼 2스트라이크", "3스트라이크",
                            "3스트라이크", "게임 종료");
                },
                1, 2, 3, 4, 5, 6
        );
    }
}

