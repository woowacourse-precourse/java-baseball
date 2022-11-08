package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
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
    void 컴퓨터_숫자_랜덤_생성_테스트() {
        Computer computer = new Computer();

        assertThat(computer.getNumbers().size()).isEqualTo(3);
        computer.getNumbers().forEach(number ->
                assertThat(number).isBetween(1, 9)
        );
    }

    @Test
    void 볼_스트라이크_상황_테스트() {
        Game game = new Game();
        game.initializeGame();

        assertRandomNumberInRangeTest(
                () -> {
                    run("426");
                    assertThat(game.getBallCount()).isEqualTo(1);
                    assertThat(game.getStrikeCount()).isEqualTo(1);
                },
                1,4,6
        );
    }

    @Test
    void 볼_스트라이크_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("234", "567", "891", "271", "273");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼", "낫싱", "2스트라이크", "3스트라이크");
                },
                2, 7, 3
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
    void 예외_테스트_범위_벗어난_사용자_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("210"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_사용자_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("221"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
