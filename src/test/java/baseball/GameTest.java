package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
  Game game;

  @BeforeEach
  public void setUp(){
    game = new Game(1);
  }

  @Test
  public void isGameStartWhenFlagIs1(){
    game = new Game(1);
    Assertions.assertThat(game.toBeContinued).isEqualTo(1);
  }
}