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
    void 중복된_숫자_입력(){
        String input = "121";
        assertThatThrownBy(()-> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 적은_숫자_입력(){
        String input = "12";
        assertThatThrownBy(()-> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 많은_숫자_입력(){
        String input = "1234";
        assertThatThrownBy(()-> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_입력() {
        String input = "12a";
        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_출력_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("214", "351", "312", "135", "2");
                    assertThat(output()).contains("1볼", "3볼", "2볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 스트라이크_출력_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "135", "1", "523", "589", "2");
                    assertThat(output()).contains("1스트라이크", "3스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 스트라이크_볼_동시_출력_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("152", "135", "1", "597", "598", "589","2");
                    assertThat(output()).contains("1볼 1스트라이크", "3스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 낫싱_출력_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
