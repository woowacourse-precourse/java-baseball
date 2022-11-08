package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("NextBehavior 테스트: 1,2 외에 값을 입력하면 IllegalArgumentException")
    void nextBehaviorExceptionTest () throws Exception {
        assertThatThrownBy(()->new NextBehavior("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Guess 테스트: 조건 외에 값을 입력하면 IllegalArgumentException")
    void guessExceptionTest () throws Exception {
        assertThatThrownBy(()->new Guess("89"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Guess("506"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Guess("998"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
