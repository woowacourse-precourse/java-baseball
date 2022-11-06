package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCycleTest {
    @Test
    public void numberDrawTest() throws Exception{
        //given
        GameCycle game = new GameCycle();
        //expect
        System.out.println(game.drawNumber());

    }

}