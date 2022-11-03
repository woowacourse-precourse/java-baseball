package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Game_랜덤으로_숫자생성() {
        Game game1 = new Game();
        Game game2 = new Game();

        assertThat(game1.computer).isNotEqualTo(game2.computer);
    }

    @Test
    void getStrike_스트라이크_갯수_1() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 2, 3);

        assertThat(game.getStrike(game.computer, player)).isEqualTo(3);
    }

    @Test
    void getStrike_스트라이크_갯수_2() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 4, 3);

        assertThat(game.getStrike(game.computer, player)).isEqualTo(2);
    }

    @Test
    void getStrike_스트라이크_갯수_3() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(3 , 2, 1);

        assertThat(game.getStrike(game.computer, player)).isEqualTo(1);
    }

    @Test
    void getBall_볼_갯수_1() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 2, 3);

        assertThat(game.getBall(game.computer, player)).isEqualTo(0);
    }

    @Test
    void getBall_볼_갯수_2() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(3 , 2, 1);

        assertThat(game.getBall(game.computer, player)).isEqualTo(2);
    }

    @Test
    void getBall_볼_갯수_3() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player = List.of(3 , 1, 2);

        assertThat(game.getBall(game.computer, player)).isEqualTo(3);
    }
}

