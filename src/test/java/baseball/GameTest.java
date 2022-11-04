package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
  Game game;

  @BeforeEach
  public void setUp(){
    game = new Game(1);
  }

  @Test
  @DisplayName("Game 생성 테스트")
  public void isGameStartWhenFlagIs1(){
    game = new Game(1);
    Assertions.assertThat(game.toBeContinued).isEqualTo(1);
  }

  @Test
  @DisplayName("유효성 검사")
  public void generateNumberValidate() {
    game = new Game(1);
    boolean result = game.validityChecker(game.generateNumber());
    assertEquals(result, true);
  }

  @Test
  @DisplayName("유효성 검사 1. Null 확인")
  public void generateNumberValidateIsStringNotNull() {
    assertEquals(game.generateNumber() != null, true);
  }
}