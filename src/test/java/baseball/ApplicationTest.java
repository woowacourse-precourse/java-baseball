package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;

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
    void testCheckLength() {
        Application app = new Application();
        String trueNumber = "123";
        String falseNumber = "12";

        assertThat(app.checkLength(trueNumber)).isTrue();
        assertThat(app.checkLength(falseNumber)).isFalse();
    }

    @Test
    void testCheckIsDigit() {
        Application app = new Application();
        String trueNumber = "123";
        String falseNumber = "a2b";

        assertThat(app.checkIsDigit(trueNumber)).isTrue();
        assertThat(app.checkIsDigit(falseNumber)).isFalse();
    }

    @Test
    void testCreateAnswer() {
        String answer = Application.createAnswer();

        assertThat(answer.length()).isEqualTo(3);
        for (int i=0; i<3; i++){
            assertThat(answer.charAt(i)).isLessThanOrEqualTo('9');
            assertThat(answer.charAt(i)).isGreaterThanOrEqualTo('1');
        }
    }

    @Test
    void testIsStrike() {
        Application app = new Application();

        assertThat(app.isStrike("123","123")).isTrue();
        assertThat(app.isStrike("123","321")).isFalse();
    }

    @Test
    void testIsStop() {
        Application app = new Application();

        assertThat(app.isStop("2")).isTrue();
        assertThat(app.isStop("1")).isFalse();
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
