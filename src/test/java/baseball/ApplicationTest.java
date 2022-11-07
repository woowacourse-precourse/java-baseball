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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void isThreeNumber_메서드_올바른_값_테스트() {
        String input = "123";
        boolean result = true;
        assertThat(Application.isThreeNumber(input)).isEqualTo(result);
    }

    @Test
    void isThreeNumber_메서드_잘못된_값_길이_테스트() {
        String input = "1234";
        boolean result = false;
        assertThat(Application.isThreeNumber(input)).isEqualTo(result);
    }

    @Test
    void isThreeNumber_메서드_잘못된_값_문자_테스트() {
        String input = "12a";
        boolean result = false;
        assertThat(Application.isThreeNumber(input)).isEqualTo(result);
    }

    @Test
    void isDifferentNumber_메서드_올바른_값_테스트() {
        String input = "123";
        boolean result = true;
        assertThat(Application.isDifferentNumber(input)).isEqualTo(result);
    }

    @Test
    void isDifferentNumber_메서드_잘못된_값_중복_테스트() {
        String input = "121";
        boolean result = false;
        assertThat(Application.isDifferentNumber(input)).isEqualTo(result);
    }

    @Test
    void isValidNumber_메서드_올바른_값_테스트() {
        String input = "123";
        boolean result = true;
        assertThat(Application.isDifferentNumber(input)).isEqualTo(result);
    }

    @Test
    void isValidNumber_메서드_잘못된_값_테스트() {
        String input = "11a";
        boolean result = false;
        assertThat(Application.isDifferentNumber(input)).isEqualTo(result);
    }

    @Test
    void isOneOrTwo_메서드_올바른_값_테스트() {
        String input = "1";
        boolean result = true;
        assertThat(Application.isOneOrTwo(input)).isEqualTo(result);
    }

    @Test
    void isOneOrTwo_메서드_잘못된_값_테스트() {
        String input = "4";
        boolean result = false;
        assertThat(Application.isOneOrTwo(input)).isEqualTo(result);
    }

    @Test
    void checkIfDone_메서드_끝난_경우_테스트() {
        String input = "2";
        boolean result = true;
        assertThat(Application.checkIfDone(input)).isEqualTo(result);
    }

    @Test
    void checkIfDone_메서드_재시작하는_경우_테스트() {
        String input = "1";
        boolean result = false;
        assertThat(Application.checkIfDone(input)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
