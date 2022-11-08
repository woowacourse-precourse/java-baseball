package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Hint;
import baseball.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameControllerTest {

    @DisplayName("재시작 명령이면 정답을 랜덤으로 재생성하고, 종료 명령이면 게임의 상태를 바꾼다. 이후 결과가 초기화된다.")
    @Test
    void 재시작과_종료_동작_테스트() {
        Game game = new Game();
        Player player = new Player();
        Computer computer = new Computer();
        GameController gameController = new GameController(game, player, computer);
        List<Integer> answerBall = computer.getBalls();

        String restart = "1";
        gameController.setActionOfRestartAndExit(restart);
        Assertions.assertThat(answerBall).isNotEqualTo(computer.getBalls());

        String exit = "2";
        gameController.setActionOfRestartAndExit(exit);
        Assertions.assertThat(game.isExitStatus()).isTrue();

        Assertions.assertThat(game.toString()).isEqualTo(Hint.NOTHING.symbol());
    }
}
