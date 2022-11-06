package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    @Test
    void listNumber1() {
        String numList = "123456789";
        assertThat(Application.removeRepetitionNumber(numList)).isEqualTo(123);
    }


    @Test
    void listNumber2() {
        String numList = "1222222223";
        assertThat(Application.removeRepetitionNumber(numList)).isEqualTo(123);
    }

    @Test
    void listNumber3() {
        String numList = "1122345678";
        assertThat(Application.removeRepetitionNumber(numList)).isEqualTo(123);
    }

    @Test
    void removeRepetition() {
        String numList = "484647168";
        assertThat(Application.removeRepetitionNumber(numList)).isEqualTo(486);
    }

    @Nested
    class userInputTest {
        @Test
        void userInput1() {
            int num = 12;
            assertThatThrownBy(() -> Application.exceptionHandler(num))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("n은 세자리 숫자입니다.");
        }

        @Test
        void userInput2() {
            int num = 1234;
            assertThatThrownBy(() -> Application.exceptionHandler(num))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("n은 세자리 숫자입니다.");
        }

        @Test
        void userInput3() {
            int num = 1;
            assertThatThrownBy(() -> Application.exceptionHandler(num))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("n은 세자리 숫자입니다.");
        }

        @Test
        void userInput4() {
            int num = 123;
            assertThat(Application.exceptionHandler(num)).isEqualTo(123);
        }

        @Test
        void userInput5() {
            int num = (int) (Math.random() * 1000) + 1;
            System.out.println("num = " + num);

            if (!(num >= 100 && num < 1000)) {
                assertThatThrownBy(() -> Application.exceptionHandler(num))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("n은 세자리 숫자입니다.");
            }
        }
    }


    @Nested
    class restartTest {
        @Test
        void restartGame1() {
            int num = 2;
            assertThat(Application.breakExceptionHandler(num)).isEqualTo(num);
        }

        @Test
        void restartGame12() {
            int num = 3;
            if (!(num == 1 || num == 2)) {
                assertThatThrownBy(() -> Application.breakExceptionHandler(num))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 또는 2를 입력해야 합니다.");
            }
        }
    }

    @Nested
    class checkStrikeTest{
        @Test
        void checkStrike1 () {
        assertThat(Application.checkStrikeCount(123, 143)).isEqualTo(2);
        }

        @Test
        void checkStrike2 () {
        assertThat(Application.checkStrikeCount(123, 456)).isEqualTo(0);
        }

        @Test
        void checkStrike3 () {
        assertThat(Application.checkStrikeCount(123, 173)).isEqualTo(2);
        }

        @Test
        void checkStrike4 () {
        assertThat(Application.checkStrikeCount(123, 321)).isEqualTo(1);
        }
    }

    @Nested
    class checkBallTest {
        @Test
        void checkBall1() {
            assertThat(Application.checkBallCount(123, 143)).isEqualTo(0);
        }

        @Test
        void checkBall2() {
            assertThat(Application.checkBallCount(987, 765)).isEqualTo(1);
        }

        @Test
        void checkBall3() {
            assertThat(Application.checkBallCount(915, 125)).isEqualTo(1);
        }

        @Test
        void checkBall4() {
            assertThat(Application.checkBallCount(915, 159)).isEqualTo(3);
        }
    }


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
