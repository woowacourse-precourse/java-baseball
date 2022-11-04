package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
  Game game;

  private static ByteArrayOutputStream outContent;
  private static PrintStream originalOut;

  @BeforeEach
  public void setUp(){
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    game = new Game(1);
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }
  @Test
  @DisplayName("Game 생성 테스트")
  public void isGameStartWhenFlagIs1(){
    Assertions.assertThat(game.toBeContinued).isEqualTo(1);
  }

  @Test
  @DisplayName("유효성 검사 테스트")
  public void generateNumberValidate() {
    game.generateNumberTest("1");
  }

  @Test
  @DisplayName("유효성 검사 1. Null 확인")
  public void generateNumberValidateIsStringNotNull() {
    Assertions.assertThatThrownBy(() -> {
      game.generateNumberTest("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("유효성 검사 2. 유효한 값 1 확인")
  public void generateNumberValidateIsStringOne() {
    game.generateNumberTest("1");
    assertEquals("1", outContent.toString());
  }
  @Test
  @DisplayName("유효성 검사 3. 유효한 값 2 확인")
  public void generateNumberValidateIsStringTwo() {
    game.generateNumberTest("2");
    assertEquals("2", outContent.toString());
  }

}