package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void 게임진행중_3볼_2볼1스트라이크_추가() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "312", "132", "123", "2");
                    assertThat(output()).contains("낫싱", "3볼", "2볼 1스트라이크" ,"3스트라이크");
                },
                1,2,3
        );
    }

    @Test
    void 게임종료_후_2번의_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "1", "456", "1", "789", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                },
                1,2,3,4,5,6,7,8,9
        );
    }

    @Test
    void 정답이후_바로_게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "123", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1,2,3
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
