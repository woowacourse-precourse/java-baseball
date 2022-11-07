package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest extends NsTest {

    @DisplayName("게임 시작 후 종료까지")
    @Test
    void playGame() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        org.assertj.core.api.Assertions.assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
    }

    @DisplayName("스트라이크 갯수 확인")
    @Test
    void checkStrike() {
        BaseBall game = new BaseBall();
        int num1 = 123;
        int num2 = 321;
        int result = 1;
        game.checkStrike(num1, num2);
        assertThat(game.strike).isEqualTo(result);
    }

    @DisplayName("볼 갯수 확인")
    @Test
    void checkBall() {
        BaseBall game = new BaseBall();
        int num1 = 123;
        int num2 = 321;
        int result = 2;
        game.checkBall(num1, num2);
        assertThat(game.ball).isEqualTo(result);
    }

    @DisplayName("상태 출력 메시지 확인")
    @Test
    void print_state() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "234", "321", "2");
                assertThat(output()).contains("2볼 1스트라이크", "2볼", "3스트라이크", "게임 종료");
                },
                3,2,1
        );
    }

    @DisplayName("스트라이크, 볼 초기화")
    @Test
    void init_Strike_Ball() {
        BaseBall game = new BaseBall();
        game.strike = 10;
        game.ball = 5;
        game.init_Strike_Ball();
        assertThat(game.ball).isEqualTo(0);
        assertThat(game.strike).isEqualTo(0);
    }

    @Test
    void right_answer_그리고_restart_기능확인() {
        BaseBall game = new BaseBall();

        assertRandomNumberInRangeTest(() ->
        {
            run("123", "1","123","2");
            assertThat(output()).contains(game.restart_Message, game.end_Message, game.match_Message);
        },
                1,2,3,1,2,3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
