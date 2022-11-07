package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    @Nested
    class GameTest{
        Game game = new Game();
        @Test
        void 스트라이크_갯수_체크1(){
            final List<Integer> targetNumber = List.of(4, 8, 6);
            final List<Integer> playerNumber = List.of(4, 8, 7);
            final BaseBall baseBall = new BaseBall();
            final int strike = 2;

            final int result = game.countStrike(targetNumber, playerNumber, baseBall);

            assertThat(strike).isEqualTo(result);
        }
        @Test
        void 스트라이크_갯수_체크2(){
            final List<Integer> targetNumber = List.of(5, 8, 6);
            final List<Integer> playerNumber = List.of(4, 8, 7);
            final BaseBall baseBall = new BaseBall();
            final int strike = 1;

            final int result = game.countStrike(targetNumber, playerNumber, baseBall);

            assertThat(strike).isEqualTo(result);
        }

        @Test
        void 스트라이크_갯수_체크3(){
            final List<Integer> targetNumber = List.of(4, 8, 7);
            final List<Integer> playerNumber = List.of(4, 8, 7);
            final BaseBall baseBall = new BaseBall();
            final int strike = 3;

            final int result = game.countStrike(targetNumber, playerNumber, baseBall);

            assertThat(strike).isEqualTo(result);
        }

        @Test
        void 볼_갯수_체크1(){
            final List<Integer> targetNumber = List.of(4, 8, 6);
            final List<Integer> playerNumber = List.of(8, 6, 7);
            final BaseBall baseBall = new BaseBall();
            final int ball = 2;

            final int result = game.countBall(targetNumber, playerNumber, baseBall);

            assertThat(ball).isEqualTo(result);
        }

        @Test
        void 볼_갯수_체크2(){
            final List<Integer> targetNumber = List.of(3, 6, 7);
            final List<Integer> playerNumber = List.of(2, 9, 3);
            final BaseBall baseBall = new BaseBall();
            final int ball = 1;

            final int result = game.countBall(targetNumber, playerNumber, baseBall);

            assertThat(ball).isEqualTo(result);
        }

        @Test
        void 볼_갯수_체크3(){
            final List<Integer> targetNumber = List.of(1, 2, 8);
            final List<Integer> playerNumber = List.of(2, 8, 1);
            final BaseBall baseBall = new BaseBall();
            final int ball = 3;

            final int result = game.countBall(targetNumber, playerNumber, baseBall);

            assertThat(ball).isEqualTo(result);
        }

        @Test
        void 숫자_유효성_검사1(){
            final String num = "1234";

            Throwable thrown = catchThrowable(() -> {throw new IllegalArgumentException("유효하지 않은 값");});

            assertThat(thrown).isInstanceOf(Exception.class)
                    .hasMessageContaining("유효하지 않은 값");
        }

        @Test
        void 숫자_유효성_검사2(){
            final String num = "치이카와";

            Throwable thrown = catchThrowable(() -> {throw new IllegalArgumentException("유효하지 않은 값");});

            assertThat(thrown).isInstanceOf(Exception.class)
                    .hasMessageContaining("유효하지 않은 값");
        }

    }

}
