package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void 랜덤_숫자_길이_테스트() {
        String randomNumber = Application.createRandomNumber();
        assertThat(randomNumber.length()).isEqualTo(3);
    }

    @Test
    void 리스트_문자열_변환_테스트() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(Application.toString(list)).isEqualTo("123");
    }

    @Test
    void 스트라이크_개수_테스트() {
        String randomNumber = "123";
        String baseballNumber = "";

        baseballNumber = "123";
        assertThat(Application.getStrike(randomNumber, baseballNumber)).isEqualTo(3);

        baseballNumber = "153";
        assertThat(Application.getStrike(randomNumber, baseballNumber)).isEqualTo(2);

        baseballNumber = "135";
        assertThat(Application.getStrike(randomNumber, baseballNumber)).isEqualTo(1);

        baseballNumber = "312";
        assertThat(Application.getStrike(randomNumber, baseballNumber)).isEqualTo(0);
    }

    @Test
    void 볼_개수_테스트() {
        String randomNumber = "123";
        String baseballNumber = "";

        baseballNumber = "123";
        assertThat(Application.getBall(randomNumber, baseballNumber)).isEqualTo(0);

        baseballNumber = "345";
        assertThat(Application.getBall(randomNumber, baseballNumber)).isEqualTo(1);

        baseballNumber = "241";
        assertThat(Application.getBall(randomNumber, baseballNumber)).isEqualTo(2);

        baseballNumber = "312";
        assertThat(Application.getBall(randomNumber, baseballNumber)).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_낫싱_판별_테스트() {
        String randomNumber = "123";
        String baseballNumber = "";

        baseballNumber = "123";
        assertThat(Application.getHint(randomNumber, baseballNumber)).isEqualTo("3스트라이크");

        baseballNumber = "345";
        assertThat(Application.getHint(randomNumber, baseballNumber)).isEqualTo("1볼");

        baseballNumber = "134";
        assertThat(Application.getHint(randomNumber, baseballNumber)).isEqualTo("1볼 1스트라이크");

        baseballNumber = "456";
        assertThat(Application.getHint(randomNumber, baseballNumber)).isEqualTo("낫싱");
    }

    @Test
    void 게임_종료_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output())
                            .contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 2, 3
        );
    }

    @Test
    void 입력_숫자_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_숫자_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("h2y"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_숫자_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("777"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_여부_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.validateRestartNumber("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
