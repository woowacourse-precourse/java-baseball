package baseball.test.domainTest;

import baseball.domain.Game;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void getStrikeTest() {
        Game game = new Game();
        assertThat(game.getStrike()).isEqualTo(0);
    }

    @Test
    void getBallTest() {
        Game game = new Game();
        assertThat(game.getBall()).isEqualTo(0);
    }

    @Test
    void checkBallTest() {
        Game game = new Game();
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 1, 2);
        game.checkBall(computer, user);
        assertThat(game.getBall()).isEqualTo(3);
    }

    @Test
    void checkStrikeTest() {
        Game game = new Game();
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);
        game.checkBall(computer, user);
        assertThat(game.getStrike()).isEqualTo(3);
    }

    @Test
    void ThreeStrikeCheckTest() {
        Game game = new Game();
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);
        game.checkBall(computer, user);
        assertThat(game.ThreeStrikeCheck()).isEqualTo(false);
    }

    @Test
    void addBallTest() {
        Game game = new Game();
        game.addBall();
        assertThat(game.getBall()).isEqualTo(1);
    }

    @Test
    void addStrikeTest() {
        Game game = new Game();
        game.addBall();
        game.addStrike();
        assertThat(game.getStrike()).isEqualTo(1);
    }
}
