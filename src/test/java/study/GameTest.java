package study;

import static baseball.Game.DEFAULT_LEN;

import baseball.Game;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){

        game = new Game(DEFAULT_LEN);
    }




}
