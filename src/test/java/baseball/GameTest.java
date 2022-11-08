package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void judgeEqualTest() {
        Game testGame = new Game();
        Game.computer = new ArrayList<Integer>(List.of(1,2,3));
        Game.user = new ArrayList<Integer>(List.of(3,2,1));
        testGame.judge();
        assertEquals(new ArrayList<Integer>(List.of(2,1)), Game.ballCount);
    }

    @Test
    void validateUserThrowTest() {
        Game testGame = new Game();
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validateUser("12345");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validateUser("210");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validateUser("222");
        });
    }

    @Test
    void confirmRestartThrowTest() {
        Game testGame = new Game();
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.confirmRestart("0");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validateUser("3");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validateUser("@");
        });
    }

}