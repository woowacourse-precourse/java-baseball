package baseball.game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void playerInputTest() throws Exception {
        //given
        String input = "123";

        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Player player = new Player();
        player.setInputNumber();
        String playerNumber = player.getInputNumber();

        //then
        assertEquals(playerNumber, "123");
    }

}