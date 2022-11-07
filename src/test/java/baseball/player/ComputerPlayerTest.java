package baseball.player;

import baseball.baesball.Baseball;
import baseball.baesball.ComputerBaseballGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static baseball.game.GameRule.BASEBALL_MAX_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerTest {
    private final ComputerPlayer computerPlayer = new ComputerPlayer();

    @RepeatedTest(100)
    @DisplayName("컴퓨터 야구공 생성 성공 테스트")
    void whenPlayGameThenSuccessTest() {
        Baseball baseball = computerPlayer.playGame(new ComputerBaseballGenerator());
        List<Integer> balls = baseball.getBaseballs();
        assertThat(balls).hasSize(BASEBALL_MAX_SIZE.getRule());
    }
}