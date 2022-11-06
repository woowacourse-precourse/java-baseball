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
    @Test
    public void numberLengthIsThreeTest() {
        //given;
        String inputTrue = "123";
        String inputFalse = "12344";
        //expect
        assertEquals(game.numberLengthIsThree(inputTrue), true);
        assertThrows(IllegalArgumentException.class,()->game.numberLengthIsThree(inputFalse));
    }
    @Test
    public void validIsDigit() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "12b";
        //expect
        assertEquals(game.numberIsDigit(inputTrue), true);
        assertThrows(IllegalArgumentException.class,()->game.numberIsDigit(inputFalse));
    }
    @Test
    public void validNotZero() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "120";
        //expect
        assertEquals(game.numberIsNotZero(inputTrue), true);
        assertThrows(IllegalArgumentException.class,()->game.numberIsNotZero(inputFalse));
    }
    @Test
    public void validNotDuplicate() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "112";
        //expect
        assertEquals(game.numberIsNotDuplicate(inputTrue), true);
        assertThrows(IllegalArgumentException.class,()->game.numberIsNotDuplicate(inputFalse));
    }
    @Test
    public void checkPlayer() throws Exception {
        //given
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String playerNumber = game.playerInputNumber();

        //then
        assertEquals(playerNumber, "123");
        //given
        input = "1234";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        assertThrows(IllegalArgumentException.class, ()->game.playerInputNumber());
    }
    @Test
    public void countStrike() throws Exception {
        //given
        String answer = "123";
        String input = "123";
        //when
        assertEquals(game.countStrike(answer, input), 3);
        //then
    }
    @Test
    public void countBall() throws Exception {
        //given
        String answer = "312";
        String input = "123";
        //expect
        assertEquals(game.countBall(answer, input), 3);
    }
}