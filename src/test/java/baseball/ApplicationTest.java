package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "1", "123", "597", "329", "579", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료", "낫싱", "2볼 1스트라이크", "1스트라이크", "3스트라이크", "게임 종료", "게임 종료");
                },
                1, 2, 3, 5, 7, 9
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
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("155"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정답_판독() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 정답_판독2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "351", "237", "157", "135");
                    assertThat(output()).contains("낫싱", "3볼", "1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 랜덤_숫자_생성() {
        String number = Application.createRandomNumber();
        assertThat(number.length()).isEqualTo(3);
        assertThat(number.charAt(0)).isNotEqualTo(number.charAt(1)).isNotEqualTo(number.charAt(2));
        assertThat(number.charAt(1)).isNotEqualTo(number.charAt(2));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
