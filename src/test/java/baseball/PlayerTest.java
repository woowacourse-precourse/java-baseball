package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void player3NumberInput() {

        Player player = new Player(new ArrayList<>());

        assertThat(player.playerNumber).isEmpty();

    }

    @Test
    void isNumeric() {

        String s = "english";

        assertThat(Player.isNumeric(s)).isFalse();
    }

    @Test
    void doubleCheck() {

        String s = "112";

        assertThat(Player.doubleCheck(s)).isFalse();
    }
}