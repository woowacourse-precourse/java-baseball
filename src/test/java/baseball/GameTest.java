package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}