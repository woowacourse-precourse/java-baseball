package baseball.domain.game;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameInitTest {

  private static GameImpl baseballGame;
  private static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";

  @BeforeAll
  static void test_init() {
    baseballGame = new GameImpl();
  }

  @Test
  @DisplayName("게임이 시작되면 정해진 게임 시작 문구를 출력한다.")
  void game_init_test(){
    assertEquals(INIT_MESSAGE, baseballGame.GameInit());
  }
}
