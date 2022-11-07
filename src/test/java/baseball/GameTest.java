package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameTest {

    @Test
    void 스트라이크() {

        Computer computer = new Computer(new ArrayList<>());
        computer.computerNumber = List.of(1, 2, 3);
        Player player = new Player(new ArrayList<>());
        player.playerNumber = List.of(1, 2, 3);

        Integer strike = Game.strike(computer, player, 0);
        Assertions.assertThat(strike).isEqualTo(3);

    }

    @Test
    void 볼() {

        Computer computer = new Computer(new ArrayList<>());
        computer.computerNumber = List.of(1, 2, 3);
        Player player = new Player(new ArrayList<>());
        player.playerNumber = List.of(3, 1, 2);

        Integer ball = Game.ball(computer, player, 0);
        Assertions.assertThat(ball).isEqualTo(3);

    }
}