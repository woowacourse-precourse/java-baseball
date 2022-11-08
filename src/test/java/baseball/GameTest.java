package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    @Test
    @DisplayName("새로운 숫자야구 게임 시작 테스트")
    void start_test_game_start() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("새로운 숫자야구 게임 시작 메시지 출력 테스트")
    void printGameStartMessage_test_print_message() {
        Game game = new Game();
        game.printGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("사용자 입력 1인 경우 재시작 여부 확인 테스트")
    void askRestart_test_restart_true() {
        Game game = new Game();
        String testInput = "1";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(game.askRestart()).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자 입력 2인 경우 재시작 여부 확인 테스트")
    void askRestart_test_restart_false() {
        Game game = new Game();
        String testInput = "2";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(game.askRestart()).isEqualTo(false);
    }

    public void runMain() {
        new Game().start();
    }
}
