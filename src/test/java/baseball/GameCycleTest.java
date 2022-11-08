package baseball;

import baseball.game.GameCycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameCycleTest {
    private static GameCycle game;

    @BeforeEach
    public void beforeEach() {
        game = new GameCycle();
    }


    @Test
    public void numberLengthIsThreeTest() {
        //given;
        String inputTrue = "123";
        String inputFalse = "12344";
        //expect
        assertEquals(game.numberLengthIsThree(inputTrue), true);
        assertThrows(IllegalArgumentException.class, () -> game.numberLengthIsThree(inputFalse));
    }

    @Test
    public void validIsDigit() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "12b";
        //expect
        assertEquals(game.numberIsDigit(inputTrue), true);
        assertThrows(IllegalArgumentException.class, () -> game.numberIsDigit(inputFalse));
    }

    @Test
    public void validNotZero() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "120";
        //expect
        assertEquals(game.numberIsNotZero(inputTrue), true);
        assertThrows(IllegalArgumentException.class, () -> game.numberIsNotZero(inputFalse));
    }

    @Test
    public void validNotDuplicate() throws Exception {
        //given
        String inputTrue = "123";
        String inputFalse = "112";
        //expect
        assertEquals(game.numberIsNotDuplicate(inputTrue), true);
        assertThrows(IllegalArgumentException.class, () -> game.numberIsNotDuplicate(inputFalse));
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
        assertThrows(IllegalArgumentException.class, () -> game.playerInputNumber());
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

    @Test
    public void countResponseTest() throws Exception {
        //expect
        assertEquals(game.countResponse("312", "123"), "3볼");
        assertEquals(game.countResponse("123", "145"), "1스트라이크");
        assertEquals(game.countResponse("123", "142"), "1볼 1스트라이크");
    }

    @Test
    public void printResultTest() throws Exception {
        //given
        String input = "3스트라이크";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.output(input);
        //expect
        assertThat(input).isEqualTo(out.toString().trim());
    }
}