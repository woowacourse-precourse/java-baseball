package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Duration;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTimeout;


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
    void 예외_테스트_를_테스트() {
            assertThatThrownBy(() -> runException("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_숫자_반환() {
        String computer = "123";
        String user = "123";
        int result = Application.countSameLetterInSameIndexWithoutDuplicate(computer, user);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_숫자_반환() {
        String computer = "12345";
        String user = "54321";
        int result = Application.countSameLetterInDifferentIndexWithoutDuplicate(computer, user);

        assertThat(result).isEqualTo(4);
    }


    @Test
    void Timeout_Test() {
        assertTimeoutPreemptively(Duration.ofSeconds(1L),
                () -> assertThatThrownBy(() -> Application.isValidBaseballNumber("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자맞추기_입력_길이_예외_테스트() {
            assertThatThrownBy(() -> Application.isValidBaseballNumber("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자맞추기_입력_문자_예외_테스트() {
        assertThatThrownBy(() -> Application.isValidBaseballNumber("12T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자맞추기_입력_중복_예외_테스트() {
        assertThatThrownBy(() -> Application.isValidBaseballNumber("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재시작_길이_예외_테스트() {
        String answer = "123";
        boolean result = Application.isValidAnswer(answer);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void 게임_재시작_문자_예외_테스트() {
        String answer = "a";
        boolean result = Application.isValidAnswer(answer);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void 게임_재시작_길이_예외없음_테스트() {
        String answer = "1";
        boolean result = Application.isValidAnswer(answer);

        assertThat(result).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
