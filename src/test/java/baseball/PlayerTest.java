package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void player3NumberInput() {

        Player player = new Player(new ArrayList<>());

        assertThat(player.playerNumber).isEmpty();

    }
}