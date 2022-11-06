package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameCycleTest {
    private static GameCycle game;
    @BeforeEach
    public void beforeEach(){
        game = new GameCycle();
    }

    @Test
    public void numberDrawTest() throws Exception{
        //given
        //expect
        System.out.println(game.drawNumber());
    }

    @Test
    public void playerInput() throws Exception {
        //given
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String playerNumber = game.inputNumber();

        //then
        assertEquals(playerNumber, "123");
    }

}