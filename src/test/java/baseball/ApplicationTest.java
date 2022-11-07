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
    void validateInputNumberTest_사용자_입력_길이가_3이_아닐_때 () {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateInputNumberTest_사용자_입력이_문자일_때 () {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("hii"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkPlayerResult_스트라이크가_3일_때_true () {
        int ball = 0;
        int strike = 3;
        boolean result = checkPlayerResult(ball, strike);

        assertThat(result).isTrue();
    }

    @Test
    void checkPlayerResult_스트라이크가_3이_아닐_때_false () {
        int ball = 0;
        int strike = 2;
        boolean result = checkPlayerResult(ball, strike);

        assertThat(result).isFalse();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private boolean checkPlayerResult(int ball, int strike) {
        boolean correctFlag = false;
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike != 0 && strike != 3) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 3) {
            System.out.printf("%d스트라이크\n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            correctFlag = true;
        } else {
            System.out.println("낫싱");
        }
        return correctFlag;
    }
}
